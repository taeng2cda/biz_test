<%--
  Created by IntelliJ IDEA.
  User: Green
  Date: 2022-03-24
  Time: 오후 1:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> 게시판 목록</h1>

<table>
    <tr>
        <th>글번호</th>
        <th>제목</th>
        <th>내용</th>
        <th>작성자</th>
        <th>최근 수정일</th>
        <th>게시판 작성일</th>
        <th>삭제</th>
    </tr>
    <c:forEach var="vo" items="${list}" >
        <tr>
            <td> <a href="<%=request.getContextPath()%>/posts/update?id=${vo.id}">${vo.id}</a></td>
            <td> ${vo.title}</td>
            <td> ${vo.content}</td>
            <td> ${vo.email}</td>
            <td> ${vo.updated_at}</td>
            <td> ${vo.created_at}</td>
            <td> <a href="<%=request.getContextPath()%>/posts/delete?id=${vo.id}">글삭제</a> </td>
        </tr>
    </c:forEach>



</table>
 <!-- 페이징처리 -->
<div>
    <c:if test="${startPage > 10}">
        <a href="<%=request.getContextPath()%>/posts/list?pageNum=${startPage-1}">[이전페이지]</a>
    </c:if>
    <c:forEach var="i" begin="${startPage}" end="${endPage}">
        <c:choose>
            <c:when test="${pageNum == i}">
               <span style=" color: red">${i}</span>
            </c:when>
            <c:otherwise>
                <a href="<%=request.getContextPath()%>/posts/list?pageNum=${i}"><span style=" color: gray">${i}</span></a>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    <c:if test="${endPage < pageCount}">
        <a href="<%=request.getContextPath()%>/posts/list?pageNum=${endPage + 1}">[다음페이지]</a>
    </c:if>
</div>

<a href="${pageContext.request.contextPath}/posts/create">생성</a>


</body>
</html>
