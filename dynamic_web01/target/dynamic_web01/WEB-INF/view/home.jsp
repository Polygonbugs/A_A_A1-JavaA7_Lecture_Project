<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color: <%=(String)request.getAttribute("color") %>">직접 생성한 JSP/Servlet 페이지</h1>
	<form action="./home" method="get">
		<input type="text" name="color">
		<button type="submit">전송</button>
	</form>
</body>
</html>