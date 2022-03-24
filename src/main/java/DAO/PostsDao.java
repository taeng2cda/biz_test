package main.java.DAO;

import main.java.VO.PostsVo;
import main.jdbc.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PostsDao {
    public PostsDao(){}

    //게시판 목록


    //게시판 생성
    public int insert(PostsVo vo){
        Connection con = null;
        PreparedStatement pstmt = null;

        try{
            con = JDBCUtil.getCon();
            String sql ="insert into posts values(?,?,?,?,DEFAULT,DEFAULT)";
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1,vo.getId());
            pstmt.setString(2,vo.getTitle());
            pstmt.setString(3,vo.getContent());
            pstmt.setString(4,vo.getUser_id());

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
