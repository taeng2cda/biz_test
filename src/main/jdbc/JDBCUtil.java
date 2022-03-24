package main.jdbc;

import java.sql.*;

public class JDBCUtil {

    public static Connection getCon() {
        Connection con = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/usertable";

            con = DriverManager.getConnection(url, "root", "root");
            return con;

        } catch (ClassNotFoundException ce) {
            System.out.println("실패 : " + ce.getMessage());
        } catch (SQLException se) {
            System.out.println("DB에러 : " + se.getMessage());
        }
        return null;
    }

    //커넥션 닫기
    public static void closeConn(Connection con) {
        try {
            if (con != null) con.close();
        } catch (SQLException s) {
            s.printStackTrace();
        }
    }

    public static void close(Statement stmt){
        try{
            if(stmt!=null) stmt.close();
        }catch (SQLException se){
            se.printStackTrace();
        }
    }

    public static void close(ResultSet rs){
        try{
            if(rs!=null) rs.close();
        }catch (SQLException se){
            se.printStackTrace();
        }
    }

    public static void close(Connection con, Statement stmt,ResultSet rs){
        try{
            if (con != null) con.close();
            if(stmt!=null) stmt.close();
            if(rs!=null) rs.close();
        }catch (SQLException se){
            se.printStackTrace();
        }
    }


}
