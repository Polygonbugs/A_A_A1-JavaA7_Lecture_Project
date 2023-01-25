<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>방명록</title>
	<%@ include file="./module/css_js_import.jsp" %>
</head>
<body>
<%@ include file="./module/top_nav.jsp" %>
<h2>방명록</h2>
<c:url var="visitUrl" value="/visit" />
<form action="${visitUrl }" method="post">
	<div>
		<textarea rows="3" cols="25" name="context"></textarea>
	</div>
	<div>
		<button type="submit">등록</button>
	</div>
</form>
<div>
	<form action="${visitUrl }">
		<select name="cnt" onchange="submit();">
			<option value="2" ${requestScope.paging.pageLimit eq 2 ? "selected" : "" }>2 개</option>
			<option value="10" ${requestScope.paging.pageLimit eq 10 ? "selected" : "" }>10 개</option>
			<option value="15" ${requestScope.paging.pageLimit eq 15 ? "selected" : "" }>15 개</option>
			<option value="20" ${requestScope.paging.pageLimit eq 20 ? "selected" : "" }>20 개</option>
			<option value="25" ${requestScope.paging.pageLimit eq 25 ? "selected" : "" }>25 개</option>
			<option value="30" ${requestScope.paging.pageLimit eq 30 ? "selected" : "" }>30 개</option>
		</select>
	</form>
</div>
<ul>
	<c:forEach var="data" items="${requestScope.paging.page }">
		<fmt:formatDate type="both" pattern="yyyy년 MM월 dd일 HH시 mm분 ss초" var="date" value="${data.createDate }"/>
		<li>${data.userId } | ${data.context } | ${date }</li>
	</c:forEach>
</ul>
<ul class="pagination">
	<c:set var="pageNumber" value="${empty param.p ? 1 : param.p }" />
	<c:choose>
		<c:when test="${requestScope.paging.prevPage eq -1 }">
			<li class="paging-item disabled"><a class="page-link">prev</a></li>
		</c:when>
		<c:otherwise>
			<li class="page-item"><a class="page-link" href="${visitUrl }?p=${requestScope.paging.prevPage }">prev</a></li>
		</c:otherwise>
	</c:choose>
	<c:forEach var="pNum" items="${requestScope.paging.pageList }">
		<li class="page-item ${pNum eq param.p ? 'active' : ''}"><a class="page-link" href="${visitUrl }?p=${pNum }">${pNum }</a></li>
	</c:forEach>
	<c:choose>
		<c:when test="${requestScope.paging.nextPage eq -1 }">
			<li class="page-item disabled"><a class="page-link">next</a></li>
		</c:when>
		<c:otherwise>
			<li class="page-item"><a class="page-link" href="${visitUrl }?p=${requestScope.paging.nextPage }">next</a></li>
		</c:otherwise>
	</c:choose>
</ul>
</body>
</html>