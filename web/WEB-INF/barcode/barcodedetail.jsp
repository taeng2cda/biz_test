<%--
  Created by IntelliJ IDEA.
  User: Green
  Date: 2022-04-07
  Time: 오후 2:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="../../css/BarCodeDetail.css">
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>상세페이지</h1>

<div>
    <table>
        <tr>
            <th id="th11">제품 고유키</th>
            <td id="td11">${b_id}</td>
            <th id="th12">수정한 날짜</th>
            <td id="td12">${b_updated_at}</td>
        </tr>
        <tr>
            <th>바코드키</th>
            <td>${b_barcodekey}</td>
            <th>생성된 날짜</th>
            <td>${b_created_at}</td>
        </tr>
        <tr>
            <th id="th15">제품명</th>
            <td colspan="3";><textarea id="b_title" name="b_title" value="${b_title}" cols="254" rows="1"  ></textarea></td>
        </tr>
        <tr>
            <th>제품 설명</th>
            <td colspan="3";><textarea id="b_content" name="b_content" value="${b_content}" cols="254" rows="1" ></textarea></td>
        </tr>
    </table>
    <a href="#" id="atag11">바코드 목록</a>
    <input type="submit" value="Update" id="btn11">

    <form method="post" action="<%=request.getContextPath()%>/barcode/detail" >
        <input type="hidden" name="b_id" value="${b_id}">
        <input type="hidden" name="hiddenbarcodekey" value="${b_barcodekey}">
        <input type="submit" value="이미지 저장"  id="btn12">
    </form>
</div>
</body>
</html>
