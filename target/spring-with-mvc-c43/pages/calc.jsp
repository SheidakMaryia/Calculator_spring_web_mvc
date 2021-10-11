<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 28.09.2021
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="background: #fdead3">
<jsp:include page="_header.jsp"/>
<%--spring form--%>

<s:form method="post" action="/calc" modelAttribute="mathOperation">
    <s:input path="num1" placeholder="Number 1"/>
    <s:errors path="num1"/>
    <s:input path="num2" placeholder="Number 2"/>
    <s:errors path="num2"/>

    <s:select path="typeOfOperation">
        <option value="addition">Addition</option>
        <option value="division">Division</option>
        <option value="multiplication">Multiplication</option>
        <option value="subtraction">Subtraction</option>
    </s:select>
    <s:button>Calculate</s:button>
</s:form>
<p>Result: ${result}</p>






<%--without validation and spring form--%>
<%--<form action="/calc" method="post">--%>
<%--    <input type="number" placeholder="Num 1" name="num1">--%>
<%--    <input type="number" placeholder="Num 2" name="num2">--%>
<%--    <select name="typeOfOperation">--%>
<%--        <option value="addition">Addition</option>--%>
<%--        <option value="division">Division</option>--%>
<%--        <option value="multiplication">Multiplication</option>--%>
<%--        <option value="subtraction">Subtraction</option>--%>
<%--    </select>--%>

<%--    <button>Submit</button>--%>
<%--</form>--%>
<%--<p>Result: ${result}</p>--%>

<%--<a class="btn btn-primary" href="/history" role="button">History</a>--%>
<%--<br>--%>
<%--<a class="btn btn-primary" href="/user/logOut" role="button">Log out</a>--%>

</body>
</html>
