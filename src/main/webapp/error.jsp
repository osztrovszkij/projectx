<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: roski
  Date: 4/27/16
  Time: 8:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file="css/main.css"%>
    </style>
    <title>Error</title>
</head>
<body>
<header>
    <h1>Sorry for error</h1>
</header>
<nav class="button_list">
    <a href="/projectx/dashboard"><button>Dashboard</button></a>
</nav>
<section class="wrap">
    <div class="observ">
        <h2>
            Error:
            <c:out value="${error}"/>
        </h2>
    </div>
    <div rel="main"></div>
</section>
<footer>
    <p>©2016 DreamTeam Ltd.<p>
</footer>
</body>
</html>
