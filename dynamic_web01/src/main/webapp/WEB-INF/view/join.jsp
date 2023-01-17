<%--
  Created by IntelliJ IDEA.
  User: houstonjustin
  Date: 2023/01/17
  Time: 9:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>회원가입</title>
    <c:url var="staticUrl" value="../static" />
    <link type="text/css" rel="stylesheet" href="${staticUrl }/bs5/css/bootstrap.min.css">
    <link type="text/javascript" rel="stylesheet" href="${staticUrl}/bs5/js/bootstrap.bundle.min.js">
</head>
<body>
    <h1>회원가입</h1>
    <c:url var="joinUrl" value="/join" />
    <form action="${joinUrl }" method="post">
        <div>
            <label>아이디</label>
            <input type="text" name="userId">
            <c:if test="${not empty requestScope.error}">
                <span style="color: red;">${requestScope.error}</span>
            </c:if>
        </div>
        <div>
            <label>패스워드</label>
            <input type="password" name="password">
        </div>
        <div>
            <label>이메일</label>
            <input type="email" name="email" value="${param.email}">
        </div>
        <div>
            <button type="submit">가입</button>
        </div>
    </form>
</body>
</html>
