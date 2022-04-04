<%--
  Created by IntelliJ IDEA.
  User: Green
  Date: 2022-04-01
  Time: 오후 3:48
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
    <p id="title">404 Error</p>
    <p> 페이지가 존재하지 않거나, 사용할 수 없는 페이지입니다.<br>
        주소가 올바른지 다시 한번 확인해주세요. </p>

    <a href="${pageContext.request.contextPath}/main.do">메인으로 돌아가기</a>
</div>
</body>
</html>