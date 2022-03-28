<%--
  Created by IntelliJ IDEA.
  User: Green
  Date: 2022-03-23
  Time: 오후 1:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>회원 가입</h1>

<form method="post" action="<%=request.getContextPath()%>/join">
    <table>
        <tr>
            <th>ID</th>
            <td><input type="text" name="email" id="email" value="" onkeyup="Check()"></td>
            <td> <span id="idcheck"></span> </td>
        </tr>
        <tr>
            <th>Pw</th>
            <td><input type="password" name="pw" value=""></td>
        </tr>
        <tr>
            <th>name</th>
            <td><input type="text" name="name" value=""></td>
        </tr>
        <tr>
            <td><input type="submit" value="회원 가입"></td>
        </tr>
    </table>
</form>
</body>
<script>

    var xhr=null;

    function Check(){
        xhr=new XMLHttpRequest();
        xhr.onreadystatechange=success;
        let findid = document.getElementById("email").value;
        console.log(findid);

        if(findid==""){
            document.getElementById("idcheck").innerHTML="";
            return;
        }
        xhr.open('get','${pageContext.request.contextPath}/idcheck?findid='+ findid,true);
        xhr.send();
    }
    function success(){
        if(xhr.readyState==4 && xhr.status==200){
            let xml=xhr.responseXML;
            let exist=xml.getElementsByTagName("exist")[0].textContent;
            let span=document.getElementById("idcheck");
            if(exist=='true'){
                span.innerHTML="사용중인 아이디입니다.";
            }else{
                span.innerHTML="사용가능한 아이디입니다.";
            }
        }
    }


</script>
</html>
