<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
    <%@ include file="./module/css_js_import.jsp"%>
</head>
<body>
<h1>로그인</h1>
<c:url var="loginUrl" value="/login" />
<form action="${loginUrl }" method="post">
    <div>
        <label>아이디</label>
        <input type="text" name="userId" value="${cookie.remember.value }">
        <c:if test="${not empty requestScope.error }">
            <span style="color: red;">${requestScope.error }</span>
        </c:if>
    </div>
    <div>
        <label>패스워드</label>
        <input type="password" name="password">
    </div>
    <div>
        <label for="id_remember">아이디 기억하기</label>
        <c:choose>
            <c:when test="${empty cookie.remember }">
                <input type="checkbox" id="id_remember" name="remember">
            </c:when>
            <c:otherwise>
                <input type="checkbox" id="id_remember" name="remember" checked>
            </c:otherwise>
        </c:choose>
    </div>
    <div>
        <button type="submit">로그인</button>
    </div>
</form>
</body>
</html>