<%--
  Created by IntelliJ IDEA.
  User: houstonjustin
  Date: 2023/01/13
  Time: 10:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.dto.BookmarkDTO" %>
<html>
<head>
    <title>즐겨찾기 수정</title>
</head>
<body>
    <div>
        <c:url var="bookmarkUrl" value="/bookmark" />
        <a href="${bookmarkUrl }">돌아가기</a>
    </div>
    <h2>수정 폼</h2>
    <form action="${bookmarkUrl }" method="post">
        <input type="hidden" name="id" value="${requestScope.data.id }">
        <input type="text" name="url" value="${requestScope.data.url }">
        <input type="text" name="name" value="${requestScope.data.name }">
        <div>
            <button type="submit">수정</button>
        </div>
    </form>
</body>
</html>
