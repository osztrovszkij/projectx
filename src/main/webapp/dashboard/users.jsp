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
    <title>Users</title>
</head>
<body>
<header>
    <h1>User management</h1>
</header>
<nav>
    <a href="/projectx/"><button>Main page</button></a><br>
    <a href="/projectx/dashboard"><button>Dashboard</button></a><br>
</nav>
<section>

    <h1>User management</h1>

    <table>
        <thead>
        <tr>
            <th>Login</th>
            <th>password</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach  var="user" items="${users}">
            <tr>
                <td><c:out value="${user.login}" /></td>
                <td><c:out value="${user.password}" /></td>
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
