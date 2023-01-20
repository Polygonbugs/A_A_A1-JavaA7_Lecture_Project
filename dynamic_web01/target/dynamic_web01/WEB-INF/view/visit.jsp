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
			<option value="10" ${requestScope.cnt eq 10 ? "selected" : ""}>10개</option>
			<option value="15" ${requestScope.cnt eq 15 ? "selected" : ""}>15개</option>
			<option value="20" ${requestScope.cnt eq 20 ? "selected" : ""}>20개</option>
			<option value="25" ${requestScope.cnt eq 25 ? "selected" : ""}>25개</option>
			<option value="30" ${requestScope.cnt eq 30 ? "selected" : ""}>30개</option>
		</select>
	</form>
</div>
<ul>
	<c:forEach var="data" items="${requestScope.dataList }">
		<fmt:formatDate type="both" pattern="yyyy년 MM월 dd일 HH시 mm분 ss초" var="date" value="${data.createDate }"/>
		<li>${data.userId } | ${data.context } | ${date }</li>
	</c:forEach>
</ul>
<div>
	<c:set var="pageNumber" value="${empty param.p ? 1: param.p}"/>
	<c:choose>
		<c:when test="${pageNumber eq 1}">
			<a>prev</a>
		</c:when>
		<c:otherwise>
			<a href="${visitUrl }?p=${pageNumber - 1}">prev</a>
		</c:otherwise>
	</c:choose>
	<c:forEach var="pNum" items="${requestScope.pageList }">
		<a href="${visitUrl }?p=${pNum }">${pNum }</a>
	</c:forEach>
	<c:choose>
		<c:when test="${pageNumber eq requestScope.lastPageNumber }">
			<a>next</a>
		</c:when>
		<c:otherwise>
			<a href="${visitUrl }?p=${pageNumber + 1}">next</a>
		</c:otherwise>
	</c:choose>
</div>
</body>
</html>