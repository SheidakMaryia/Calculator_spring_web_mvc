<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 28.09.2021
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/calc" method="post">
    <input type="number" placeholder="Num 1" name="num1">
    <input type="number" placeholder="Num 2" name="num2">
    <select name="typeOfOperation">
        <option value="addition">Addition</option>
        <option value="division">Division</option>
        <option value="multiplication">Multiplication</option>
        <option value="subtraction">Subtraction</option>
    </select>

    <button>Submit</button>
</form>
<p>Result: ${result}</p>

<a class="btn btn-primary" href="/history" role="button">History</a>
<br>
<a class="btn btn-primary" href="/user/logOut" role="button">Log out</a>

</body>
</html>
