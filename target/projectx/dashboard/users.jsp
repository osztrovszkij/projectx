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
    <title>Users</title>
</head>
<body>
<header>
    <h1>User management</h1>
</header>
<nav class="button_list">
    <a href="/projectx/dashboard"><button>Dashboard</button></a>
</nav>
<section class="wrap">
    <div class="observ">
        <h2>User management</h2>
        <h3>Users</h3>
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
                    <td><c:out value="${user.role}" /></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="list">
        <form class="form" action="users" method="post" name="form">
            <input type="hidden" name="request" value="add_user"/>
            <h3>Add user</h3>
            <ul>
                <li>
                    <label for="add_login">Login</label>
                    <input type="text" name="login" id="add_login"/>
                </li>
                <li>
                    <label for="add_password">Password</label>
                    <input type="text" name="password" id="add_password"/>
                </li>
                <li>
                    <label for="add_role">Role</label>
                    <input type="text" name="role" id="add_role"/>
                </li>
            </ul>
            <button class="submit" type="submit">Add user</button>
            <c:out value="${messages['add_user']}"/>
        </form>
    </div>
    <div class="list">
        <form class="form" action="users" method="post" name="form">
            <input type="hidden" name="request" value="update_user"/>
            <h3>Update user</h3>
            <ul>
                <li>
                    <label for="update_login">Login</label>
                    <input type="text" name="login" id="update_login"/>
                </li>
                <li>
                    <label for="update_password">Password</label>
                    <input type="text" name="password" id="update_password"/>
                </li>
                <li>
                    <label for="update_role">Role</label>
                    <input type="text" name="role" id="update_role"/>
                </li>
            </ul>
            <button class="submit" type="submit">Update user</button>
            <c:out value="${messages['update_user']}"/>
        </form>
    </div>
    <div class="list">
        <form class="form" action="users" method="post" name="form">
            <input type="hidden" name="request" value="delete_user"/>
            <h3>Delete user</h3>
            <ul>
                <li>
                    <label for="delete_login">Login</label>
                    <input type="text" name="login" id="delete_login"/>
                </li>
            </ul>
            <button class="submit" type="submit">Delete user</button>
            <c:out value="${messages['delete_user']}"/>
        </form>
    </div>
    <div rel="main"></div>
</section>
<footer>
    <p>©2016 DreamTeam Ltd.<p>
</footer>
</body>
</html>
