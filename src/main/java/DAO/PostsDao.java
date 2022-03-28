package main.java.DAO;

import main.java.VO.PostsVo;
import main.jdbc.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class PostsDao {
    public PostsDao(){}

    //게시판 목록
    public ArrayList<PostsVo> PostsList(int startRow, int endRow){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
        con = JDBCUtil.getCon();
        String sql = "select * from posts order by id desc limit 10 OFFSET ?";

            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,startRow);
            rs = pstmt.executeQuery();
            ArrayList<PostsVo> list = new ArrayList<PostsVo>();

            while (rs.next()){
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                int user_id = rs.getInt("user_id");
                Date created_at = rs.getDate("created_at");
                Date updated_at = rs.getDate("updated_at");

                PostsVo vo = new PostsVo(id,title,content,user_id,created_at,updated_at);
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

}
