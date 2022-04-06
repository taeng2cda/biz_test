<%--
  Created by IntelliJ IDEA.
  User: Green
  Date: 2022-03-28
  Time: 오후 5:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>

        table {	border: 1px solid black; border-collapse: collapse }
        th{
            border: 1px solid black; border-collapse: collapse;
            width: 200px;
        }
        td{
            border: 1px solid black; border-collapse: collapse;
            width: 250px;
        }
        #buttonbox{
            height: 40px;
            padding-right: 10px;
        }
        #update{
            background-color: #444444; border-color: #444444;
            color: white; border-radius: 3px;
            text-align: right;
        }
        #delete{
            background-color: #e74040; border-color: #e74040;
            color: white; border-radius: 3px;
            margin-left: 10px;
            text-align: right;
        }
        #postslist{
            text-align: left;
            padding-left: 10px;
            padding-right: 600px;
        }
        #t_title{
            height: 30px;
        }
        #title{
            width: 100%; height: 100%;
        }
        #t_content{
            height: 200px;
        }
        #content{
            width: 100%; height: 100%;
        }
    </style>
</head>
<body>
<h1>글 수정</h1>

<form method="post" id="updateform" action="<%=request.getContextPath()%>/posts/update">
    <!-- 히든 타입으로 숨겨 value값을 자바스크립트에 넘길것임 -->
    <!-- user_id = 유저테이블의 pk -->
    <input type="hidden" id="user_id" name="user_id" value="${user_id}" >
    <!-- postsfk = 게시판테이블의 fk -->
    <input type="hidden" id="postsfk" name="postsfk" value="${postsfk}" >
    <table id="table">
        <tr>
            <th>글번호</th>
            <td>${postsid} <input type="hidden" name="posts_id" value="${postsid}"> </td>
            <th>작성날짜</th>
            <td>${posts_created_at}</td>
        </tr>
        <tr>
            <th>작성자</th>
            <td><input type="hidden" id="email" name="users_email" value="${email}" >${email}</td>
            <th>수정한날짜</th>
            <td>${posts_updated_at}</td>
        </tr>
        <tr>
            <th>제목</th>
            <td id="t_title"colspan="3";>
                <textarea id="title" name="title" value="" cols="254" rows="1" readonly >${title}</textarea>
            </td>
        </tr>
        <tr>
            <th >내용</th>
            <td id="t_content"colspan="3";>
                <textarea id="content" name="content" value="" cols="50" rows="10" readonly >${content}</textarea>
            </td>
        </tr>
        <tr>
            <td id="buttonbox" colspan="4";>
                <a href="${pageContext.request.contextPath}/posts/list" id="postslist">게시판 목록 보기</a>
                <c:choose>
                    <c:when test="${user_id == postsfk}">
                        <input type="button" id="update" value="수정하기" onclick="postsupdate()">
                        <input type="button" id="delete" value="삭제하기" onclick="postsdelete()">
                    </c:when>
                    <c:otherwise>

                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </table>
</form>

<!-- delete 숨길 페이지-->
<form method="post" id="deleteform" action="<%=request.getContextPath()%>/posts/delete" >
    <input type="hidden" value="${postsid}" name="posts_id">
</form>

<!-- 댓글창 구현하기-->
<div>
    <h3>댓글 [변수]개</h3>

</div>
<!-- 댓글 작성창-->
<div>

</div>

</body>
</html>
<script>

    // 작성자가 맞다면 글수정이 가능하고 작성자가 아닐경우 수정이 불가능하도록 만드는 메소드
    window.onload = function () {
        // 테스트용 유저테이블의 email 컬럼  아이디용
        var email = document.getElementById("email").value;
        // 유저테이블의 pk값
        var user_id = document.getElementById("user_id").value;
        // 게시판테이블의 fk값
        var postsfk = document.getElementById("postsfk").value;
        console.log(email);
        console.log(user_id);
        console.log(postsfk);
        if (user_id == postsfk) {
            document.getElementById("title").readOnly  = false;
            document.getElementById("content").readOnly  = false;
        } else {
            document.getElementById("title").readOnly  = true;
            document.getElementById("content").readOnly  = true;
        }
    }

    function postsdelete(){
        var Check = confirm("글을 삭제하실 건가요?");
        if(Check){
            alert("해당 글은 삭제처리 되었습니다.");
            document.getElementById("deleteform").submit();
        }else{

        }
    }
    function postsupdate(){
        var Check = confirm("글을 수정하시겠습니까?");
        if(Check){
            alert("수정완료되었습니다");
            document.getElementById("updateform").submit();
        }else{

        }
    }

</script>