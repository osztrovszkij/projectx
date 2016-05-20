<%@ page import="entity.User" %><%--
  Created by IntelliJ IDEA.
  User: roski
  Date: 20.5.16
  Time: 16.01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>
<header>
    <h1>Hard party</h1>
</header>
<nav>
    <a href="/projectx/">Main page</a>
    <a href="/projectx/dashboard/order">Make Order</a>
    <a href="/projectx/dashboard/profile">My Profile</a>
    <br>
    <a href="/projectx/dashboard/users">User management</a>
    <a href="/projectx/dashboard/services">Service management</a>
</nav>
<section>
    <h1><% String username = ((User) session.getAttribute("user")).getUsername();%>
        It's a dashboard. Hi, <%=username%> !</h1>
</section>
<footer>
    <p>©2016 DreamTeam Ltd.<p>
</footer>
</body>
</html>
