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
    <title>Services</title>
</head>
<body>
<header>
    <h1>Service management</h1>
</header>
<nav>
    <a href="/projectx/"><button>Main page</button></a><br>
    <a href="/projectx/dashboard"><button>Dashboard</button></a><br>
</nav>
<section>

    <h1>Service management</h1>

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

    <form class="form" action="services" method="post" name="form">
        <input type="hidden" name="request" value="add_service"/>
        <h2>Add service</h2>
        <ul>
            <li>
                <label for="add_name">Name</label>
                <input type="text" name="name" id="add_name"/>
            </li>
            <li>
                <label for="add_description">Description</label>
                <input type="text" name="description" id="add_description"/>
            </li>
        </ul>
        <button class="submit" type="submit">Add service</button>
        <c:out value="${messages['add_service']}"/>
    </form>

    <form class="form" action="services" method="post" name="form">
        <input type="hidden" name="request" value="update_service"/>
        <h2>Update service</h2>
        <ul>
            <li>
                <label for="update_name">Name</label>
                <input type="text" name="name" id="update_name"/>
            </li>
            <li>
                <label for="update_description">Description</label>
                <input type="text" name="description" id="update_description"/>
            </li>
        </ul>
        <button class="submit" type="submit">Update service</button>
        <c:out value="${messages['update_service']}"/>
    </form>

    <form class="form" action="services" method="post" name="form">
        <input type="hidden" name="request" value="delete_service"/>
        <h2>Delete service</h2>
        <ul>
            <li>
                <label for="delete_name">Name</label>
                <input type="text" name="name" id="delete_name"/>
            </li>
        </ul>
        <button class="submit" type="submit">Delete service</button>
        <c:out value="${messages['delete_service']}"/>
    </form>

</section>
<footer>
    <p>©2016 DreamTeam Ltd.<p>
</footer>
</body>
</html>