<%--
  Created by IntelliJ IDEA.
  User: Green
  Date: 2022-03-22
  Time: 오후 2:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
  <h1>로그인 페이지</h1>
    <br>
  <form method="post" action="<%=request.getContextPath()%>/login">
      ID<input type="text" name="email" value=""><br>
      PW<input type="password" name="pw" value=""><br>
    <input type="submit" value="로그인">
  </form>




</body>


</html>
