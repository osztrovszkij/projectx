<%@ page import="entity.User" %><%--
  Created by IntelliJ IDEA.
  User: roski
  Date: 4/28/16
  Time: 11:19 AM
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
