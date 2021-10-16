<%--
  Created by IntelliJ IDEA.
  User: etoal
  Date: 16.10.2021
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Вход</title>
    <link href="../css/reset.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <link href="../css/styles.css" rel="stylesheet">
</head>
<body>
<header style="background-color: #4B7F7E">
    <div class="container">
        <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
            <a href="${pageContext.request.contextPath}/home" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
                <img src="../images/logo.jpg" class="bi  me-2" width="80" height="42" alt="Главная">
            </a>

            <ul class="nav nav-tabs">
                <li class="nav-item"><a href="${pageContext.request.contextPath}/home" class="nav-link text-white" aria-current="page">Главная</a></li>
                <li class="nav-item"><a href="#" class="nav-link text-white">Посты</a></li>
                <li class="nav-item"><a href="#" class="nav-link text-white">Товары</a></li>
                <li class="nav-item"><a href="${pageContext.request.contextPath}/registration" class="nav-link active" style="color: #4B7F7E">Регистрация</a></li>
                <li class="nav-item"><a href="${pageContext.request.contextPath}/signIn" class="nav-link text-white">Вход</a></li>
            </ul>
        </header>
    </div>
</header>
<div class="form-signin text-center">
    <form method="post" action="${pageContext.request.contextPath}/registration">
        <h1 class="h3 mb-3 fw-normal">Регистрация</h1>

        <div class="form-floating">
            <input type="text" class="form-control" id="nickname" name="nickname" placeholder="name@example.com">
            <label for="nickname">Введите никнейм</label>
        </div>
        <div class="form-floating">
            <input type="email" class="form-control" id="email" name="email" placeholder="name@example.com">
            <label for="email">Введите адрес электронной почты</label>
        </div>
        <div class="form-floating">
            <input type="password" class="form-control" id="password" name="password" placeholder="Password">
            <label for="password">Введите пароль</label>
        </div>
        <div class="form-floating">
            <input type="password" class="form-control" id="password2" name="password2" placeholder="Password">
            <label for="password2">Повторите пароль</label>
        </div>
        <button class="w-100 btn btn-outline-dark" type="submit">Зарегистрироваться</button>
        <p class="info-text" style="margin-top: 0">${validation}</p>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
</body>
</html>
