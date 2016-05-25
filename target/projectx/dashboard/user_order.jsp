<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: roski
  Date: 20.5.16
  Time: 17.52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file="../css/main.css"%>
    </style>
    <title>Order</title>
</head>
<body>
<header>
    <h1>Order</h1>
</header>
<nav class="button_list">
    <a href="/projectx/dashboard"><button>Dashboard</button></a>
</nav>
<section class="wrap">
    <div class="observ">
        <h2>Services</h2>
        <table>
            <thead>
            <tr>
                <th>Name</th>
                <th>Description</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach  var="service" items="${services}">
                <tr>
                    <td><c:out value="${service.name}" /></td>
                    <td><c:out value="${service.description}" /></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="list">
    <form class="form" action="order" method="post" name="form">
        <input type="hidden" name="request" value="add_order"/>
        <h2>Add order</h2>
        <ul>
            <li>
                <label for="add_name">Service name</label>
                <input type="text" name="name" id="add_name"/>
            </li>
            <li>
                <label for="add_date">Event date</label>
                <input type="text" name="date" id="add_date"/>
            </li>
        </ul>
        <button class="submit" type="submit">Add order</button>
        <c:out value="${messages['add_order']}"/>
    </form>
    </div>
    <div rel="main"></div>
</section>
<footer>
    <p>©2016 DreamTeam Ltd.<p>
</footer>
</body>
</html>
