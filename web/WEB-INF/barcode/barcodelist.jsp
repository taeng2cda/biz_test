<%--
  Created by IntelliJ IDEA.
  User: Green
  Date: 2022-04-06
  Time: 오전 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" type="text/css" href="../../css/BarCodeList.css">
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>바코드 게시판 목록</h1>
<div id="page">
    <div id="search">
        <form action="<%=request.getContextPath()%>/barcode/list" method="post">
            <select name ="column" >
                <option value="barcodeKey"   <c:if test="${column=='barcodeKey' }">selected</c:if> >바코드키</option>
                <option value="title" <c:if test="${column=='title' }">selected</c:if> >제품명</option>
                <option value="content"   <c:if test="${column=='content' }">selected</c:if> >제품설명</option>
                <option value="title-content"   <c:if test="${column=='title-content' }">selected</c:if> >제품명 + 제품설명</option>
            </select>
            <input type="text" value="${search}" name="search">
            <input type="submit" value="검색" id="button1" >
        </form>
    </div>
    <div>
        <table>
            <tr >
                <th id="th1">제품 고유키</th>
                <th id="th2">바코드 키</th>
                <th id="th3">제품명</th>
                <th id="th4">제품 설명</th>
                <th id="th5">수정한 날짜</th>
                <th id="th6">생성된 날짜</th>
            </tr>
            <c:forEach var="vo" items="${list}" >
                <tr id="list_tr">
                    <td id="td1"> <a href="<%=request.getContextPath()%>/barcode/detail?id=${vo.id}">${vo.id}</a></td>
                    <td id="barcodeKey" > ${vo.barcodeKey}</td>
                    <td id="td3"> ${vo.title}</td>
                    <td id="td4"> ${vo.content}</td>
                    <td id="td5"> ${vo.updated_at}</td>
                    <td id="td6"> ${vo.created_at}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div id="paging">
        <c:if test="${startPage > 10}">
            <a href="<%=request.getContextPath()%>/barcode/list?pageNum=${startPage-1}&column=${column}&search=${search}">[이전페이지]</a>
        </c:if>
        <c:forEach var="i" begin="${startPage}" end="${endPage}">
            <c:choose>
                <c:when test="${pageNum == i}">
                    <span style=" color: red">${i}</span>
                </c:when>
                <c:otherwise>
                    <a href="<%=request.getContextPath()%>/barcode/list?pageNum=${i}&column=${column}&search=${search}"><span style=" color: gray">${i}</span></a>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:if test="${endPage < pageCount}">
            <a href="<%=request.getContextPath()%>/barcode/list?pageNum=${endPage + 1}&column=${column}&search=${search}">[다음페이지]</a>
        </c:if>
    </div>
</div>

</body>

</html>
