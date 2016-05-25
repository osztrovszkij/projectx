<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: roski
  Date: 4/28/16
  Time: 11:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file="css/main.css"%>
    </style>
    <title>Dashboard</title>
    <link rel="stylesheet" type="text/css" href="css/main.css" />
</head>
<body>
<header>
    <h1>Hard party</h1>
</header>
<nav>
    <a href="/projectx/dashboard/order"><button>Make Order</button></a>
    <a href="/projectx/dashboard/profile"><button>My Profile</button></a>
    <div class="logout">
        <form action="logout" method="post">
            <input type="submit" value="Logout" >
        </form>
    </div>
</nav>
<section class="wrap">
    <div class="observ">
        <h2>
            Hi, <c:out value="${user.login}"/>. It's a dashboard.
        </h2>
    </div>
    <div rel="main"></div>
</section>
<footer>
    <p>©2016 DreamTeam Ltd.<p>
</footer>
</body>
</html>
