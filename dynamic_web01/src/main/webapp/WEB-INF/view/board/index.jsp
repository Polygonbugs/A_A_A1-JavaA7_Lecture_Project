<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="../module/css_js_import.jsp"%>
<html>
<head>
    <title>게시판 목록 페이지</title>
</head>
<body>
    <c:url var="boardUrl" value="/board" />
    <div>
        <%@ include file="../module/top_nav.jsp" %>
    </div>
    <div>
        <form action="${boardUrl }">
            <select name="cnt" onchange="submit();">
                <c:forEach var="cnt" begin="5" end="30" step="5">
                    <option value="${cnt }" ${requestScope.paging.pageLimit eq cnt ? 'selected' : ''}>${cnt }개</option>
                </c:forEach>
            </select>
        </form>
    </div>
    <table>
        <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
                <th>조회수</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="data" items="${requestScope.paging.page }">
            <tr>
                <td>${data.id }</td>
                <td><a href="${boardUrl }/detail?id=${data.id }">${data.title }</a></td>
                <td>${data.writer }</td>
                <td>${data.createDate }</td>
                <td>${data.viewCnt }</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div>
        <ul class="pagination">
        <c:set var="pageNumber" value="${empty param.p ? 1 : param.p}" />
        <c:choose>
            <c:when test="${requestScope.paging.prevPage eq -1}">
                <li class="page-item disabled"><a class="page-link">prev</a></li>
            </c:when>
            <c:otherwise>
                <li class="page-item"><a class="page-link" href="${boardUrl }?p=${requestScope.paging.prevPage}">prev</a></li>
            </c:otherwise>
        </c:choose>
        <c:forEach var="pNum" items="${requestScope.paging.pageList }">
            <li class="page-item" ${pNum eq pageNumber ? 'active' : ''}><a class="page-link" href="${boardUrl }?p=${pNum }">${pNum }</a></li>
        </c:forEach>
        <c:choose>
            <c:when test="${requestScope.paging.nextPage eq -1 }">
                <li class="page-item disabled"><a class="page-link">next</a></li>
            </c:when>
            <c:otherwise>
                <li class="page-item"><a class="page-link" href="${boardUrl }?p=${requestScope.paging.nextPage }">next</a></li>
            </c:otherwise>
        </c:choose>
        </ul>
    </div>
</body>
</html>
