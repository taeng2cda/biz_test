<%--
  Created by IntelliJ IDEA.
  User: Green
  Date: 2022-03-24
  Time: 오후 3:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> 게시판 응답 결과</h1>

    <c:choose>

        <c:when test="${resultcreate=='success' }">
            <h2>요청작업 완료</h2>
        </c:when>

        <c:when test="${resultupdate=='success' }">
            <h2>게시물 수정 완료</h2>
        </c:when>

        <c:when test="${resultupdate=='fail' }">
            <h2>게시물 수정 실패</h2>
        </c:when>

        <c:when test="${resultupdate=='success' }">
            <h2>게시물 삭제 성공</h2>
        </c:when>

        <c:when test="${resultupdate=='fail' }">
            <h2>게시물 삭제 실패</h2>
        </c:when>

        <c:otherwise>
            <h2>요청작업 실패</h2>
        </c:otherwise>
    </c:choose>



<li> <a href="<%=request.getContextPath()%>/posts/list">게시판 목록</a> </li>

</body>
</html>
