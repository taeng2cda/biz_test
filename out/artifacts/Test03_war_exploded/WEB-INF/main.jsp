<%--
  Created by IntelliJ IDEA.
  User: Green
  Date: 2022-03-22
  Time: 오후 2:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <c:choose>
        <c:when test="${sessionScope.email == null}" >
            <ul>
                <li> <a href="${pageContext.request.contextPath}/login">로그인</a> </li>
                <li> <a href="${pageContext.request.contextPath}/join">회원가입</a> </li>
            </ul>
        </c:when>

        <c:when test="${sessionScope.email != null }" >
            <ul>
                <li> <a href="${pageContext.request.contextPath}/logout">로그아웃</a> </li>
                <li> <a href="${pageContext.request.contextPath}/join">회원가입</a> </li>
                <li> <a href="${pageContext.request.contextPath}/userlist">회원목록</a> </li>
                <li> <a href="${pageContext.request.contextPath}/posts/list">게시판</a> </li>
                <li> <a href="${pageContext.request.contextPath}/barcode/list">바코드 목록</a> </li>
            </ul>
        </c:when>

    </c:choose>

</body>
</html>
