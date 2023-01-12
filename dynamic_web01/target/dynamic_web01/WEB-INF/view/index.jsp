<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Random" %>
<%!
    public Random rd = new Random();
    public String title = "메인페이지";

    public String getTitle() {
	    return this.title;
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=getTitle() %></title>
</head>
<body>
	<h1>Hello JSP/Servlet</h1>
	<p>사용자 요청에 Servlet 의 메서드가 동작하여 JSP 페이지를 실행하고 최종 응답이 되었습니다.</p>
	<form action="./main" method="get">
		<input type="text" name="count" value="<%=rd.nextInt(10) %>">
	</form>
	<p>
	    <%=request.getParameter("count") %> 값을 받았습니다.
	</p>
	<ul>
	<% for(int i = 0; i < (Integer)request.getAttribute("iCnt"); i++) { %>
	    <li><%=i %>번재 목록</li>
	<% } %>
	</ul>
</body>
</html>