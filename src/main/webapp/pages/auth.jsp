<%--
  Created by IntelliJ IDEA.
  User: simonpirko
  Date: 15.09.21
  Time: 7:44 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="с" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Auth</title>
</head>
<body style="background: #fdead3">
<jsp:include page="_header.jsp"/>
<%--spring form--%>

<s:form method="post" action="/user/auth" modelAttribute="existingUser">

    <s:input path="login" placeholder="Login"/>
    <s:errors path="login"/>

    <s:input path="password" placeholder="Password"/>
    <s:errors path="password"/>

    <s:button>Submit</s:button>
</s:form>

<с:if test="${message != null}">
    <div class="alert alert-primary" role="alert">
            ${message}
    </div>
</с:if>







<%--without validation and spring form--%>
<%--<form action="/user/auth" method="post">--%>
<%--    <input type="text" name="login" placeholder="Login">--%>
<%--    <input type="password" name="password" placeholder="Password">--%>
<%--    <button>Submit</button>--%>
<%--</form>--%>
<%--<p>${message}</p>--%>
</body>
</html>
