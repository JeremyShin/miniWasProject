<%--
  Created by IntelliJ IDEA.
  User: jycs
  Date: 18. 10. 4
  Time: 오후 1:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>list</h1>
<c:if test="${sessionScope.admin != 'true'}">
    <a href="/guestbook/login">loginForAdmin</a>
</c:if>

<c:if test="${sessionScope == 'true'}">
    <a href="/guestbook/logout">logout</a>
</c:if>
<br><br>

countForContent:${requestScope.guestbookSize}<br>


<form method="post" action="/guestbook/write">
    name: <input type="text" name="name"><br>
    content: <br>
    <textarea name="content" id="content" cols="30" rows="10"></textarea>
    <input type="submit">
</form>

<!--방명록목록을출력한다.-->
<c:forEach items="${requestScope.guestbookList}" var="guestbook">
    name: ${guestbook.name}<br>
    content: ${guestbook.content}<br>
    <c:if test="${sessionScope.admin == 'true'}">
        <a href="/guestbook/delete?id=${guestbook.id}">delete</a><br><br>
    </c:if>
</c:forEach>

name: kim<br>
content: java..<br>
<a href="/guestbook/delete?id=1">delete</a>

name: lee<br>
content: haha..<br>
<a href="/guestbook/delete?id=2">delete</a>
</body>
</html>

