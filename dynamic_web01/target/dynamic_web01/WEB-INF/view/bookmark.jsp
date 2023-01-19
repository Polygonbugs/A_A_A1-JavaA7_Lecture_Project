<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>즐겨찾기</title>
    <%@ include file="./module/css_js_import.jsp"%>
</head>
<body>
<div>
    <c:url var="mainUrl" value="/" />
    <a href="${mainUrl }">메인으로</a>
</div>
<h2>즐겨찾기</h2>
<c:url var="bookmarkUrl" value="/bookmark" />
<form action="${bookmarkUrl }" method="post">
    <div>
        <label>URL 주소:</label><input type="text" name="url">
    </div>
    <div>
        <label>별칭:</label><input type="text" name="name">
    </div>
    <div>
        <button type="submit">등록</button>
    </div>
</form>
<ul>
    <c:forEach var="d" items="${requestScope.data }">
        <c:url var="bookmarkUpdateUrl" value="/bookmark/update">
            <c:param name="id" value="${d.id }" />
        </c:url>
        <li>
            <a href="${d.url }">${d.name }</a>
            <button type="button" onclick="location.href='${bookmarkUpdateUrl }'">수정</button>
            <button type="submit" form="deleteForm${d.id }">삭제</button>
            <form id="deleteForm${d.id }" action="${bookmarkUrl }/delete" method="post">
                <input type="hidden" name="id" value="${d.id }">
            </form>
        </li>
    </c:forEach>
</ul>
</body>
</html>