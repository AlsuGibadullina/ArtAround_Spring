<%--
  Created by IntelliJ IDEA.
  User: etoal
  Date: 15.10.2021
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="../css/reset.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <title>Главная</title>
</head>
<body>
<header style="background-color: #4B7F7E">
    <div class="container">
        <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
            <a href="/home" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
                <img src="../images/logo.jpg" class="bi  me-2" width="80" height="42" alt="Главная">
            </a>

            <ul class="nav nav-tabs">
                <li class="nav-item"><a href="${pageContext.request.contextPath}/home" class="nav-link active" style="color: #4B7F7E" aria-current="page">Главная</a></li>
                <li class="nav-item"><a href="#" class="nav-link text-white">Посты</a></li>
                <li class="nav-item"><a href="#" class="nav-link text-white">Товары</a></li>
                <li class="nav-item"><a href="${pageContext.request.contextPath}/registration" class="nav-link text-white">Регистрация</a></li>
                <li class="nav-item"><a href="${pageContext.request.contextPath}/signIn" class="nav-link text-white">Войти</a></li>
            </ul>
        </header>
    </div>
</header>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
</body>
</html>
