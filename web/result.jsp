<%--
  Created by IntelliJ IDEA.
  User: Green
  Date: 2022-03-23
  Time: 오후 2:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>회원 가입 결과</h1>

<c:choose>
    <c:when test="${requestScope.result == 'success' }">
        <h1>회원가입 완료</h1><br>
    </c:when>

    <c:otherwise>
        <h1>회원가입 실패</h1>
    </c:otherwise>

</c:choose>
<a href="${pageContext.request.contextPath}/main.do">Home</a>

</body>
</html>
