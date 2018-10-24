<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>list</title>
</head>
<body>
<h1>list</h1>
<br>
<c:forEach items="${boards}" var="board">
    ${board.title}<br>
</c:forEach>

<a href="/boards/writeform">글쓰기</a>
</body>
</html>
