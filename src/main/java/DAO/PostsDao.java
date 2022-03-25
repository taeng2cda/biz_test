package main.java.DAO;

import main.java.VO.PostsVo;
import main.jdbc.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PostsDao {
    public PostsDao(){}

    //게시판 목록

    /*
    public ArrayList<PostsVo> PostsList(int startRow, int endRow){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        con = JDBCUtil.getCon();
        String sql = "";
        12월 2일 58분 쯤
        select R1.* from(
	    select * from posts order by ID asc
        ) R1
        limit 10 OFFSET 0;
   }

     */

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


    //게시판 삭제


}
