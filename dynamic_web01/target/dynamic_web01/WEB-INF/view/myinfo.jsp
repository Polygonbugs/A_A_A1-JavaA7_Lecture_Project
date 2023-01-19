<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <%@ include file="./module/css_js_import.jsp"%>
</head>
<body>
    <h1>개인정보 수정</h1>
    <c:url var="myinfoUpdateUrl" value="/myinfo" />
    <form action="${myinfo }" method="post">
        <div>
            <label>아이디</label>
            <input type="text" value="${sessionScope.user.userId }" disabled>
        </div>
        <div>
            <label>현재 패스워드</label>
            <input type="password" name="password">
        </div>
        <div>
            <label>변경할 패스워드</label>
            <input type="password" name="changePass">
        </div>
        <div>
            <label>이메일 주소</label>
            <input type="email" name="email" value="${sessionScope.user.email }">
        </div>
        <div>
            <button type="submit">저장</button>
        </div>
    </form>
</body>
</html>
