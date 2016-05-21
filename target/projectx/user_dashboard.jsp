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
    <title>Dashboard</title>
</head>
<body>
<header>
    <h1>Hard party</h1>
</header>
<nav>
    <a href="/projectx/"><button>Main page</button></a><br>
    <a href="/projectx/dashboard/order"><button>Make Order</button></a><br>
    <a href="/projectx/dashboard/profile"><button>My Profile</button></a><br>
</nav>
<section>
    <form action="logout" method="post">
        <input type="submit" value="Logout" >
    </form>
    <h1>
        Hi, <c:out value="${user.login}"/>. It's a dashboard.
    </h1>
</section>
<footer>
    <p>©2016 DreamTeam Ltd.<p>
</footer>
</body>
</html>
