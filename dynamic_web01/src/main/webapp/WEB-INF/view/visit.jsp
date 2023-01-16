<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--@ page import="java.util.List, model.dto.VisitDTO" --%>
<%--@ page import="java.text.SimpleDateFormat" --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>
</head>
<body>
	<c:url var="mainUrl" value="/" />
	<a href="${mainUrl }">메인</a>
	<h2>방명록</h2>
	<c:url var="visitUrl" value="/visit" />
	<form action="${visitUrl }" method="post">
		<div>
			<input type="text" name="nickname">
		</div>
		<div>
			<textarea rows="3" cols="25" name="context"></textarea>
		</div>
		<div>
			<button type="submit">등록</button>
		</div>
	</form>
	<%--
	<ul>
	<% SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY년 MM월 dd일 a hh시 mm분 ss초");
	   for(VisitDTO data: (List<VisitDTO>)request.getAttribute("dataList")) { %>
	       <li><%= data.getNickName() %> | <%= data.getContext() %> | <%= dateFormat.format(data.getCreateDate()) %></li>
	<% } %>
	</ul>
	--%>
	<ul>
		<!-- data.field명, 이 형식에 맞춰서 쓰면 된다 -->
		<c:forEach var="data" items="${requestScope.dataList}">
			<li>${data.nickname } | ${data.context } | <fmt:formatDate type="both" dateStyle="long" timeZone="long" var="date" value="${data.createDate}"/></li>
			<fmt:formatDate type="both" pattern="yyyy년 MM월 dd일 HH시 mm분 ss초" value="${data.createDate}"/>
			<li>${data.nickname} | ${data.context} | ${date}</li>
		</c:forEach>
	</ul>
</body>
</html>