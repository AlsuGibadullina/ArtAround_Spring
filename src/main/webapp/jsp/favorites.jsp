<%--
  Created by IntelliJ IDEA.
  User: etoal
  Date: 10.11.2021
  Time: 3:50
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="../css/reset.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <title>Фавориты</title>
    <script src="https://code.jquery.com/jquery-3.6.0.js"
            integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <style>
        .imback{
            background-image: url("../images/fon2.jpg");
            padding-bottom: 5px;
            padding-top: 5px;
        }
    </style>
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
                <li class="nav-item"><a href="${pageContext.request.contextPath}/products" class="nav-link active" style="color: #4B7F7E" aria-current="page">Товары</a></li>
                <li class="nav-item"><a href="${pageContext.request.contextPath}/registration" class="nav-link text-white">Регистрация</a></li>
                <li class="nav-item"><a href="${pageContext.request.contextPath}/signIn" class="nav-link text-white">Войти</a></li>
                <li class="nav-item"><a href="${pageContext.request.contextPath}/profile" class="nav-link text-white">Профиль</a></li>
            </ul>
        </header>
    </div>
</header>

<div id="products">
    <c:forEach var="product" items="${products}">
        <div class="row justify-content-lg-center m-lg-1 p-lg-1 border border-secondary">
            <div class="col-4">
                <img src="<c:out value="${product.photo}"/>" height="300">
            </div>
            <div class="col-4 m-5">
                <ul>
                    <li>Наименование: <c:out value="${product.title}"/></li>
                    <li>Описание: <c:out value="${product.description}"/></li>
                    <li>Вид творчества: <c:out value="${product.tag}"/></li>
                    <li>Стоимость:<c:out value="${product.cost}"/></li>
                </ul>
            </div>
            <div class="col-2 m-5">
                <ul>
                    <li>
                        <button id="remove${product.id}" onclick="removeFromFavorites(${product.id})">Убрать из фаворитов</button>
                    </li>
                </ul>
            </div>
        </div>
    </c:forEach>

</div>

<script>
    function removeFromFavorites(productId) {
        $.ajax({
            url: '/favorites',           /* Куда пойдет запрос */
            method: 'post',             /* Метод передачи (post или get) */
            dataType: 'json',          /* Тип данных в ответе (xml, json, script, html). */
            data: {
                idToRemove: productId
            },
            success: function (data) {   /* функция которая будет выполнена после успешного запроса.  */
                alert(data);            /* В переменной data содержится ответ от /products. */
            }
        })
        location.reload();
    }
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
</body>
</html>
