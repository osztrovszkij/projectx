<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file="../css/main.css"%>
    </style>
    <title>My profile</title>
</head>
<body>
<header>
    <h1>My profile</h1>
</header>
<nav class="button_list">
    <a href="/projectx/dashboard"><button>Dashboard</button></a>
</nav>
<section class="wrap">
    <div class="observ">
        <h2>Profile management</h2>
    </div>
    <div class="observ">
        <h2>Hi, <c:out value="${user.login}"/>. It's a your profile.</h2>
    </div>
    <div class="observ">
        <h2>Orders</h2>
        <table>
            <thead>
            <tr>
                <th>Order ID</th>
                <th>Order date</th>
                <th>Event date</th>
                <th>Service name</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach  var="order" items="${orders}">
                <tr>
                    <td><c:out value="${order.id}" /></td>
                    <td><c:out value="${order.orderDate}" /></td>
                    <td><c:out value="${order.eventDate}" /></td>
                    <td><c:out value="${order.service}" /></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div rel="main"></div>
</section>
<footer>
    <p>©2016 DreamTeam Ltd.<p>
</footer>
</body>
</html>