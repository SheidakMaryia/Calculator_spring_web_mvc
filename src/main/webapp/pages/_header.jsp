<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 04.10.2021
  Time: 0:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
    <title>Calculator</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Berkshire+Swash&display=swap" rel="stylesheet">

    <style type="text/css">
        * {
            margin: 0;
            padding: 0;
        }
    </style>

</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light mb-5" style="background-color: #eab471;">
    <div class="container-fluid ">
        <div class="navbar-brand" style="font-family: 'Berkshire Swash', cursive; margin-left: 40px">
            <img src="https://cdn-icons-png.flaticon.com/512/564/564429.png" alt="" height="30"
                 class="d-inline-block align-text-top">
            Calculator
        </div>


        <div style="padding-right: 150px">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <c:if test="${sessionScope.user == null}">
                <li class="nav-item">
                    <a class="nav-link active" href="/user/auth">Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="/user/reg">Sign-up</a>
                </li>
                </c:if>
                <li style="margin-left:  150px">
                    <div class="pull-right navbar-text">
                        <c:if test="${sessionScope.user == null}">
                        <a class="pull-right navbar-text" href="#" style="padding-right: 5px">Hello guest</a>
                        </c:if>
                        <c:if test="${sessionScope.user != null}">
                <li><a href="/calc" class="nav-link active">Calculator</a></li>
                <li><a href="/history" class="nav-link active">History</a></li>
                <li><p class="pull-right navbar-text" style="padding-right: 5px">Hello ${sessionScope.user.name}</p>
                </li>
                </c:if>

                <c:if test="${sessionScope.user != null}">
                <div class="dropdown text-end me-5">
                    <a href="#" class="d-block link-dark text-decoration-none dropdown-toggle" id="dropdownUser1"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        <img src="https://pngicon.ru/file/uploads/1303507907_User_Green-128x128.png"
                             alt="mdo" width="45" height="45" class="rounded">
                    </a>
                    <ul class="dropdown-menu text-big" aria-labelledby="dropdownUser1" style="">
                        <li><a href="/user/logOut" class="nav-link px-2 link-dark">Log out</a></li>

                    </ul>
                </div>
                </c:if>
        </div>
        </li>
        </ul>
    </div>

    </div>
    </div>
</nav>
<script src=" https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
</body>
</html>
