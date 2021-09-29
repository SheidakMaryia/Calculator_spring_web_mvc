<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 29.09.2021
  Time: 1:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>History of operations:</h2>
<form action="/history">

    <table class="table">
        <thead>
        <tr>
            <th scope="col">num1</th>
            <th scope="col">num2</th>
            <th scope="col">result</th>
            <th scope="col">typeOfOperation</th>
            <th scope="col">user</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${history}" var="operation">
            <tr>
                <td>${operation.num1}</td>
                <td>${operation.num2}</td>
                <td>${operation.result}</td>
                <td>${operation.typeOfOperation}</td>
                <td>${operation.user.name}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a class="btn btn-primary" href="/calc" role="button">Back to calculator</a>

</form>
</body>
</html>
