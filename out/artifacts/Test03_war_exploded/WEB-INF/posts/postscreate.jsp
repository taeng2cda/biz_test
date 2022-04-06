<%--
  Created by IntelliJ IDEA.
  User: Green
  Date: 2022-03-24
  Time: 오후 2:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>게시판 생성</h1>
test
    <form action="${pageContext.request.contextPath}/posts/create" method="post">
        글제목 <input type="text" value="" name="title"> <br>
        글내용 <input type="text" value="" name="content"> <br>
        <input type="hidden"  value="${sessionScope.user_id}" name="user_id">
        <input type="submit" value="생성하기">
    </form>

</body>
</html>
