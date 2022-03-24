<%--
  Created by IntelliJ IDEA.
  User: Green
  Date: 2022-03-24
  Time: 오후 1:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> 게시판 목록</h1>

<table>
    <tr>
        <th>닉네임(ID)</th>
        <th>제목</th>
        <th>내용</th>
        <th>ID</th>
        <th>최근 수정일</th>
        <th>게시판 작성일</th>
    </tr>
    <%--
    <c:forEach var="vo" items="list" >
        <tr>
            <td> ${vo.id}</td>
            <td> ${vo.title}</td>
            <td> ${vo.content}</td>
            <td> ${vo.user_id}</td>
            <td> ${vo.updated_at}</td>
            <td> ${vo.created_at}</td>
        </tr>

    </c:forEach>

    --%>

</table>
 <!-- 페이징처리 -->
<div>

</div>

<a href="${pageContext.request.contextPath}/posts/create">생성</a>


</body>
</html>
