<%--
  Created by IntelliJ IDEA.
  User: jycs
  Date: 18. 10. 24
  Time: 오후 3:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>writeform</title>
</head>
<body>
<h1>writeform</h1>
<br>

<form method="post" action="/boards">
    name : <input type="text" name="name"><br>
    title : <input type="text" name="title"><br>
    content : <textarea name="content" cols="50" rows="6"></textarea>
    <br>
    <input type="submit">
</form>
</body>
</html>
