<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="main.jdbc.JDBCUtil" %>
<%--
  Created by IntelliJ IDEA.
  User: Green
  Date: 2022-03-23
  Time: 오후 4:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String id=request.getParameter("findid");
    boolean exist=false;
    Connection con=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    try{
        con= JDBCUtil.getCon();
        String sql="select * from usertable where id=?";
        pstmt=con.prepareStatement(sql);
        pstmt.setString(1,id);
        rs=pstmt.executeQuery();
        if(rs.next()){
            exist=true;
        }
    }catch(SQLException s){
        s.printStackTrace();
    }finally{
        JDBCUtil.close(con, pstmt, rs);
    }
    // xml로 응답하기
    response.setContentType("text/xml;charset=utf-8");
    PrintWriter pw=response.getWriter();
    pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    pw.print("<result>");
    pw.print("<exist>"+ exist + "</exist>");
    pw.print("</result>");
%>