<%--
  Created by IntelliJ IDEA.
  User: houstonjustin
  Date: 2023/01/19
  Time: 12:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="./css_js_import.jsp"%>
</head>
<body>
<c:url var="mainUrl" value="/" />
<div>
    <a href="${mainUrl}">메인</a>
    <a href="${mainUrl}visit">방명록</a>
    <c:choose>
        <c:when test="${sessionScope.login }">
            <a href="${mainUrl}bookmark">즐겨찾기</a>
            <a href="${mainUrl}logout">로그아웃</a>
            <a href="${mainUrl}myinfo">개인정보</a>
        </c:when>
        <c:otherwise>
            <a href="${mainUrl}login">로그인</a>
            <a href="${mainUrl}join">회원가입</a>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
