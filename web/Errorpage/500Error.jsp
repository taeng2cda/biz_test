<%--
  Created by IntelliJ IDEA.
  User: Green
  Date: 2022-04-01
  Time: 오후 4:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
        rel="stylesheet">
  <style>
    .material-icons{
      font-size: 400px;
      color:goldenrod
    }
    #box{
      padding-top: 100px;
      margin: 0 auto;
      text-align: center;
    }
    #title{
      font-size: 40px;
      margin: 0px;
    }

  </style>
</head>
<body>

<div id="box">
  <span class="material-icons" id="icon"> warning_amber</span>
  <p id="title">500 Error</p>
  <p> 시스템 에러가 발생하여 페이지를 표시할 수 없습니다.<br>
    관리자에게 문의하시거나 잠시 후 다시 시도하세요.</p>

  <a href="/home">메인으로 돌아가기</a>
</div>
</body>
</html>
