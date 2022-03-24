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
            String sql="insert into usertable values(?,?,?,?,DEFAULT,NOW())";
            pstmt=con.prepareStatement(sql);

            pstmt.setString(1,vo.getId());
            pstmt.setString(2,vo.getEmail());
            pstmt.setString(3,vo.getName());
            pstmt.setString(4,vo.getPassword());

            return pstmt.executeUpdate();

        }catch(SQLException se){
            se.printStackTrace();
            return -1;
        }finally{
            JDBCUtil.close(con,pstmt,null);
        }

    }


    //로그인
    public boolean logincheck(String id, String pw) {

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        boolean check = false;
        String sql = "select * from usertable where id=?";


        try{
            con = JDBCUtil.getCon();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id );

            rs = pstmt.executeQuery();
            if(rs.next()){
                String uid = rs.getString("id");
                String upw = rs.getString("password");

                if(id.equals(uid) && pw.equals(upw)){
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
    public ArrayList userlist(){

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from usertable";

        try{
            con = JDBCUtil.getCon();
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            ArrayList<UserTableVo> list = new ArrayList<UserTableVo>();
            while(rs.next()){
                String id = rs.getString("id");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String name = rs.getString("name");
                Date created_at = rs.getDate("created_at");
                Date updated_at = rs.getDate("updated_at");

                UserTableVo vo = new UserTableVo(id,password,email,name,created_at,updated_at);
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






}
