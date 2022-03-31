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
    <input type="hidden" id="input3" name="id" value="${postsid}" >
    <h4>제목</h4>  <input type="text" id="input1" name="title" value="${title}" readonly ><br>
    <h4>내용</h4>  <input type="text" id="input2" name="content" value="${content}" readonly ><br>
    <input type="submit" value="수정하기">

    <!-- 히든 타입으로 숨겨 value값을 스크립트에 넘길것임 -->
    <!-- email = 유저테이블의 아이디-->
    <input type="hidden" id="input4" name="id" value="${email}" >
    <!-- user_id = 유저테이블의 pk -->
    <input type="hidden" id="input5" name="id" value="${user_id}" >
    <!-- postsfk = 게시판테이블의 fk -->
    <input type="hidden" id="input6" name="id" value="${postsfk}" >
</form>

</body>

</html>
<script>

    // 작성자가 맞다면 글수정이 가능하고 작성자가 아닐경우 수정이 불가능하도록 만드는 메소드
    window.onload = function () {
        // 테스트용 유저테이블의 email 컬럼  아이디용
        var value1 = document.getElementById("input4").value;
        // 유저테이블의 pk값
        var value2 = document.getElementById("input5").value;
        // 게시판테이블의 fk값
        var value3 = document.getElementById("input6").value;
        console.log(value1);
        console.log(value2);
        console.log(value3);
        if (value2 == value3) {
            document.getElementById("input1").readOnly  = false;
            document.getElementById("input2").readOnly  = false;
        } else {
            document.getElementById("input1").readOnly  = true;
            document.getElementById("input2").readOnly  = true;
        }
    }

</script>