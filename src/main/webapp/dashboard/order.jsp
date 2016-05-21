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
    <title>Order</title>
</head>
<body>
<header>
    <h1>Order</h1>
</header>
<nav>
    <a href="/projectx/"><button>Main page</button></a><br>
    <a href="/projectx/dashboard"><button>Dashboard</button></a><br>
</nav>
<section>
    <h1>Services</h1>
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
</section>
<footer>
    <p>©2016 DreamTeam Ltd.<p>
</footer>
</body>
</html>
