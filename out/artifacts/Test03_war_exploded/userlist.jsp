<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Green
  Date: 2022-03-23
  Time: 오후 5:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    table{ border : 1px solid black;}

</style>
<body>
<h1>회원 목록</h1>

<table>
    <tr>
        <th>아이디</th>
        <th>이름</th>
        <th>이메일</th>
        <th>최근 수정일</th>
        <th>회원 가입일</th>
    </tr>
        <c:forEach var="vo" items="${list}">
    <tr>
        <td>${vo.id}</td>
        <td>${vo.name}</td>
        <td>${vo.email}</td>
        <td>${vo.updated_at}</td>
        <td>${vo.created_at}</td>
    </tr>
        </c:forEach>
</table>
<div>
    <c:forEach var="i" begin="${startPage }" end="${endPage }">
        <c:choose>
            <c:when test="${i==pageNum }">
                <a href="${cp }/member/list?pageNum=${i}&keyword=${keyword}&field=${field}">
                    <span style="color:red">${i }</span>
                </a>
            </c:when>

            <c:otherwise>
                <a href="${cp}/member/list?pageNum=${i }&keyword=${keyword}&field=${field}">
                    <span style="color:black">${i }</span>
                </a>
            </c:otherwise>
        </c:choose>
    </c:forEach>
</div>
<br><a href="<%=request.getContextPath()%>/main.do">Home</a>
</body>
</html>
