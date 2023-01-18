<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>홈화면</title>
    <c:url var="staticUrl" value="/static" />
    <link type="text/css" rel="stylesheet" href="${staticUrl }/bs5/css/bootstrap.min.css">
    <script type="text/javascript" src="${staticUrl }/bs5/js/bootstrap.bundle.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.3.js" integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" crossorigin="anonymous"></script>
</head>
<body>
<c:url var="mainUrl" value="/" />
<h1>Welcome First Web Servlet</h1>
<a href="${mainUrl}visit">방명록</a>
<a href="${mainUrl}bookmark">즐겨찾기</a>
<c:choose>
    <c:when test="${sessionScope.login }">
        <a href="${mainUrl}logout">로그아웃</a>
        <a href="${mainUrl}myinfo">개인정보</a>
    </c:when>
    <c:otherwise>
        <a href="${mainUrl}login">로그인</a>
        <a href="${mainUrl}join">회원가입</a>
    </c:otherwise>
</c:choose>
</body>
</html>