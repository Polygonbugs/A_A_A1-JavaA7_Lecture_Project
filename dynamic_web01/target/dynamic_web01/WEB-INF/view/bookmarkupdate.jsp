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
    <h2>수정 폼</h2>
    <form action="./update" method="post">
        <input type="hidden" name="id" value="<%=((BookmarkDTO)request.getAttribute("data")).getId() %>">
        <input type="text" name="url" value="<%=((BookmarkDTO)request.getAttribute("data")).getUrl() %>">
        <input type="text" name="name" value="<%=((BookmarkDTO)request.getAttribute("data")).getName() %>">
        <div>
            <button type="submit">수정</button>
        </div>
    </form>
</body>
</html>
