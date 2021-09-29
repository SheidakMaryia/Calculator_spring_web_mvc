<%--
  Created by IntelliJ IDEA.
  User: simonpirko
  Date: 15.09.21
  Time: 7:44 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Auth</title>
</head>
<body>
<form action="/user/auth" method="post">
    <input type="text" name="login" placeholder="Login">
    <input type="password" name="password" placeholder="Password">
    <button>Submit</button>
</form>
<p>${message}</p>
</body>
</html>
