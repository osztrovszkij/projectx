<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Map" %>
<%--
  Created by IntelliJ IDEA.
  User: roski
  Date: 4/22/16
  Time: 9:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file="css/main.css"%>
    </style>
    <title>Login</title>
</head>
<body>
<header>
    <h1>Hard party</h1>
</header>
<section class="wrap">
    <div class="observ">
        <form action="login" method="post">
            Login: <input type="text" name="login">
            <c:out value="${messages['login']}"/>
            <br><br>
            Password: <input type="password" name="password">
            <c:out value="${messages['password']}"/>
            <br><br>
            <input type="submit" value="Login">
        </form>
    </div>
    <div rel="main"></div>
</section>
<footer>
    <p>©2016 DreamTeam Ltd.<p>
</footer>
</body>
</html>
