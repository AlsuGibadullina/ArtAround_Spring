<%--
  Created by IntelliJ IDEA.
  User: etoal
  Date: 09.11.2021
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link href="../css/reset.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <title>Профиль</title>
    <style>
        .imback{
            background-image: url("../images/fon2.jpg");
            padding-bottom: 5px;
            padding-top: 5px;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.6.0.js"
            integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</head>
<body>
<header class="imback">
    <div class="container">
        <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
            <a href="${pageContext.request.contextPath}/home" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
                <img src="../images/logo.jpg" class="bi  me-2" width="80" height="42" alt="Главная">
            </a>

            <ul class="nav nav-tabs">
                <li class="nav-item"><a href="${pageContext.request.contextPath}/home" class="nav-link text-white">Главная</a></li>
                <li class="nav-item"><a href="${pageContext.request.contextPath}/products" class="nav-link text-white">Товары</a></li>
                <li class="nav-item"><a href="${pageContext.request.contextPath}/registration" class="nav-link text-white">Регистрация</a></li>
                <li class="nav-item"><a href="${pageContext.request.contextPath}/signIn" class="nav-link text-white">Войти</a></li>
                <li class="nav-item"><a href="${pageContext.request.contextPath}/profile" class="nav-link active" style="color: #4B7F7E" aria-current="page">Профиль</a></li>
            </ul>
        </header>
    </div>
</header>
<div class="container" style="padding-top: 60px">
    <div class="row justify-content-lg-center">
        <div class="col-5">
            <h3 class="text-center">Привет, <c:out value="${user.nickname}"/></h3>
            <p class="text-center">На этой странице ты можешь посмотреть список своих фаворитов или проверить список покупок</p>
        </div>
    </div>
    <div class="row justify-content-md-center">
        <div class="col-auto">
            <button class="w-100 btn btn-outline-dark" type="submit">
                <a href="${pageContext.request.contextPath}/favorites" class="link-dark">Фавориты</a>
            </button>
        </div>
        <div class="col-1"></div>
        <div class="col-auto">
            <button class="w-100 btn btn-outline-dark" type="submit">
                <a href="${pageContext.request.contextPath}/purchases" class="link-dark">Покупки</a>
            </button>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
</body>
</html>