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
	<select>
		<option>10개</option>
		<option>15개</option>
		<option>20개</option>
		<option>25개</option>
		<option>30개</option>
	</select>
</div>
<ul>
	<c:forEach var="data" items="${requestScope.dataList }">
		<fmt:formatDate type="both" pattern="yyyy년 MM월 dd일 HH시 mm분 ss초" var="date" value="${data.createDate }"/>
		<li>${data.userId } | ${data.context } | ${date }</li>
	</c:forEach>
</ul>
<div>
	<a href="#">prev</a>
	<c:forEach var="pNum" items="${requestScope.pageList }">
		<a href="${visitUrl}?p=${pNum }">${pNum }</a>
	</c:forEach>
	<a href="#">next</a>
</div>
</body>
</html>