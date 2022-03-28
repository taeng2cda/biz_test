package main.java.DAO;

import main.java.VO.UserTableVo;
import main.jdbc.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class UserTableDao {

    public UserTableDao() {}


    // 회원가입
    public int insert(UserTableVo vo){
        Connection con = null;
        PreparedStatement pstmt = null;


        try{
            con= JDBCUtil.getCon();
            String sql="insert into users(email,name,password,created_at,updated_at) values(?,?,?,DEFAULT,DEFAULT)";
            pstmt=con.prepareStatement(sql);

            pstmt.setString(1,vo.getEmail());
            pstmt.setString(2,vo.getName());
            pstmt.setString(3,vo.getPassword());

            return pstmt.executeUpdate();

        }catch(SQLException se){
            se.printStackTrace();
            return -1;
        }finally{
            JDBCUtil.close(con,pstmt,null);
        }

    }


    //로그인
    public boolean logincheck(String email, String pw) {

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        System.out.println(pw);

        boolean check = false;
        String sql = "select * from users where email=?";

        try{
            con = JDBCUtil.getCon();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, email );

            rs = pstmt.executeQuery();
            if(rs.next()){
                String uemail = rs.getString("email");
                String upw = rs.getString("password");

                if(email.equals(uemail) && pw.equals(upw)){
                    check = true;
                }
            }
            return check;
        }catch (SQLException se){
            se.printStackTrace();
            return check;
        }finally {
            JDBCUtil.close(con,pstmt,rs);
        }

    }


    //회원 목록
    public ArrayList<UserTableVo> userlist(int startRow, int endRow ){

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            con = JDBCUtil.getCon();
            String sql = "select * from USERS order by created_at desc limit 10 OFFSET ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,startRow);
            rs = pstmt.executeQuery();
            ArrayList<UserTableVo> userlist = new ArrayList<UserTableVo>();

            while (rs.next()){
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String name = rs.getString("name");
                Date created_at = rs.getDate("created_at");
                Date updated_at = rs.getDate("updated_at");
                UserTableVo vo = new UserTableVo(id,email,name,null,created_at,updated_at);
                userlist.add(vo);
            }
            return userlist;

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
        String sql ="select COUNT(ID) from Users";
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

    // 아이디를 조회하여 사용자 정보를 세션에 담기위한 메소드
    public UserTableVo Idselect (String email){

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from users where email = ?";
        UserTableVo vo = new UserTableVo();
        try{
            con = JDBCUtil.getCon();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,email);
            rs = pstmt.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String password = rs.getString("password");
                Date created_at = rs.getDate("created_at");
                Date updated_at = rs.getDate("updated_at");

                vo.setId(id);
                vo.setName(name);
                vo.setPassword(password);
                vo.setCreated_at(created_at);
                vo.setUpdated_at(updated_at);
            }

            return vo;

        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }finally {
            JDBCUtil.close(con,pstmt,rs);
        }

    }




}
