package DAO;

import VO.PostsVo;
import jdbc.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PostsDao {
    public PostsDao(){}

    //게시판 목록
    public ArrayList<PostsVo> PostsList(int startRow, int endRow , String column , String search){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "";

        try{
        con = JDBCUtil.getCon();


        if(column == null || column.equals("")){
            sql = "select p.id , p.title , p.content , u.email , p.updated_at , p.created_at " +
                    "from posts p inner join users u " +
                    "on u.id = p.user_id " +
                    "order by created_at desc " +
                    "limit 10 offset ? ;";
        }else{
            sql = "select p.id , p.title , p.content , u.email , p.updated_at , p.created_at " +
                    "from posts p inner join users u " +
                    "on u.id = p.user_id ";

            if(column.equals("p.title")) sql += "where p.title like '%"+ search +"%' ";
            else if(column.equals("p.content"))             sql += "where p.content like '%"+ search +"%' ";
            else if(column.equals("u.email"))               sql += "where u.email like '%"+ search +"%' ";
            else if(column.equals("p.title-p.content"))     sql += "where p.title like '%"+ search +"%' or p.content like '%"+ search +"%' ";

            sql += "order by created_at desc limit 10 offset ?";
        }

            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,startRow);


            rs = pstmt.executeQuery();
            ArrayList<PostsVo> list = new ArrayList<PostsVo>();

            while (rs.next()){
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                String email = rs.getString("email");
                Date created_at = rs.getDate("created_at");
                Date updated_at = rs.getDate("updated_at");

                PostsVo vo = new PostsVo(id,title,content,email,created_at,updated_at);
                list.add(vo);

            }
            return list;

        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }finally {
            JDBCUtil.close(con,pstmt,rs);
        }


    }
    //전체 글의 갯수 리턴
    public int getCount(){
        Connection con = null;
        PreparedStatement pstmt = null;
        String sql ="select COUNT(ID) from POSTS";
        ResultSet rs = null;

        try{
            con = JDBCUtil.getCon();
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            return count;
        }catch (SQLException se){
            se.printStackTrace();
            return -1;
        }finally {
            JDBCUtil.close(con,pstmt,rs);
        }
    }

    //게시판 생성
    public int insert(PostsVo vo){
        Connection con = null;
        PreparedStatement pstmt = null;

        try{
            con = JDBCUtil.getCon();
            String sql ="insert into posts(title,content,user_id,created_at,updated_at) values(?,?,?,DEFAULT,DEFAULT)";
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1,vo.getTitle());
            pstmt.setString(2,vo.getContent());
            pstmt.setInt(3,vo.getUser_id());
            System.out.println("TEST");

            return pstmt.executeUpdate();

        }catch (SQLException se){
            se.printStackTrace();
            return -1;
        }finally {
            JDBCUtil.close(con,pstmt,null);
        }

    }

    //게시판 수정
    public int PostsUpdate(int id ,String title,String content){
        Connection con = null;
        PreparedStatement pstmt = null;
        String sql = "UPDATE POSTS SET TITLE = ? , CONTENT = ? , UPDATED_AT = DEFAULT WHERE ID = ?";

        try{
            con = JDBCUtil.getCon();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,title);
            pstmt.setString(2,content);
            pstmt.setInt(3,id);
            return pstmt.executeUpdate();

        }catch (SQLException se){
            se.printStackTrace();
            return -1;
        }finally {
            JDBCUtil.close(con,pstmt,null);
        }

    }

    //게시판 삭제
    public int PostsDelete(int id){
        Connection con = null;
        PreparedStatement pstmt = null;
        String sql = "DELETE FROM POSTS WHERE ID = ?";

        try{
            con = JDBCUtil.getCon();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,id);
            return pstmt.executeUpdate();

        }catch (SQLException se){
            se.printStackTrace();
            return -1;
        }finally {
            JDBCUtil.close(con,pstmt,null);
        }
    }

    //하나의 게시글 정보 읽어오기
    public PostsVo oneselect(int id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM POSTS WHERE ID = ?";
        PostsVo vo = new PostsVo();
        try {
            con = JDBCUtil.getCon();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            while (rs.next()){
               int id1 = rs.getInt("id");
               String title = rs.getString("title");
               String content = rs.getString("content");
               int user_id = rs.getInt("user_id");
               Date created_at = rs.getTimestamp("created_at");
               Date updated_at = rs.getTimestamp("updated_at");

               //데이터포맷
               SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일   HH시 mm분");
                String format_Created_at = simpleDateFormat.format(created_at);
                String format_Updated_at = simpleDateFormat.format(updated_at);

               vo.setId(id1);
               vo.setTitle(title);
               vo.setContent(content);
               vo.setUser_id(user_id);
               vo.setFormat_created_at(format_Created_at);
               vo.setFormat_updatred_at(format_Updated_at);

            }

            return vo;

        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        }finally {
            JDBCUtil.close(con,pstmt,rs);
        }

    }
}
