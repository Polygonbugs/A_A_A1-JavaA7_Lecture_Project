<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, model.dto.VisitDTO" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>
</head>
<body>
	<a href="./">메인</a>
	<h2>방명록</h2>
	<form action="./visit" method="post">
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
	<ul>
	<% SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY년 MM월 dd일 a hh시 mm분 ss초");
	   for(VisitDTO data: (List<VisitDTO>)request.getAttribute("dataList")) { %>
	       <li><%= data.getNickName() %> | <%= data.getContext() %> | <%= dateFormat.format(data.getCreateDate()) %></li>
	<% } %>
	</ul>
</body>
</html>