<%--
  Created by IntelliJ IDEA.
  User: Green
  Date: 2022-03-28
  Time: 오후 5:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>글 수정</h1>

<form method="post" action="<%=request.getContextPath()%>/posts/update">
    <input type="hidden" name="id" value="${postsid}">
    <h4>제목</h4>  <input type="text" name="title" value="${title}"><br>
    <h4>내용</h4>  <input type="text" name="content" value="${content}"><br>
    <input type="submit" value="수정하기">
</form>


</body>
</html>
