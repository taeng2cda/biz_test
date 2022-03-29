package main.java.Controller;

import main.jdbc.JDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/idcheck")
public class UserIdCheckController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email=req.getParameter("findid");
        boolean exist=false;
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try{
            con= JDBCUtil.getCon();
            String sql="select * from users where email=?";
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1,email);
            rs=pstmt.executeQuery();
            if(rs.next()){
                exist = true;
            }
        }catch(SQLException s){
            s.printStackTrace();
        }finally{
            JDBCUtil.close(con, pstmt, rs);
        }
        // xml로 응답하기
        resp.setContentType("text/xml;charset=utf-8");
        PrintWriter pw=resp.getWriter();
        pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        pw.print("<result>");
        pw.print("<exist>"+ exist + "</exist>");
        pw.print("</result>");
    }

}
