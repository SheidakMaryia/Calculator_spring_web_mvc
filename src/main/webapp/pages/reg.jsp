<%--
  Created by IntelliJ IDEA.
  User: simonpirko
  Date: 15.09.21
  Time: 7:42 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Reg</title>
</head>
<body style="background: #fdead3">
<jsp:include page="_header.jsp"/>

<%--spring form--%>

<s:form method="post" action="/user/reg" modelAttribute="newUser">
    <s:input path="name" placeholder="Name"/>
    <s:errors path="name"/>

    <s:input path="login" placeholder="Login"/>
    <s:errors path="login"/>

    <s:input path="password" placeholder="Password"/>
    <s:errors path="password"/>

    <s:button>Submit</s:button>
</s:form>


<%--without validation--%>
<%--<form action="/user/reg" method="post">--%>
<%--    <input type="text" name="name" placeholder="Name">--%>
<%--    <p>${name}</p>--%>
<%--&lt;%&ndash;    для вывода пояснений об ошибках во время валидации&ndash;%&gt;--%>
<%--    --%>
<%--    <input type="text" name="login" placeholder="Login">--%>
<%--    <p>${login}</p>--%>

<%--    <input type="password" name="password" placeholder="Password">--%>
<%--    <p>${password}</p>--%>
<%--    <button>Submit</button>--%>
<%--</form>--%>
</body>
</html>
