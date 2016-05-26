<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file="../css/main.css"%>
    </style>
    <title>Services</title>
</head>
<body>
<header>
    <h1>Service management</h1>
</header>
<nav class="button_list">
    <a href="/projectx/dashboard"><button>Dashboard</button></a>
</nav>
<section class="wrap">
    <div class="observ">
        <h2>Service management</h2>
    </div>
    <div class="list">
        <h3>Services</h3>
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
    </div>
    <div class="list">
        <form class="form" action="services" method="post" name="form">
            <input type="hidden" name="request" value="add_service"/>
            <h3>Add service</h3>
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
    </div>
    <div class="list">
        <form class="form" action="services" method="post" name="form">
            <input type="hidden" name="request" value="update_service"/>
            <h3>Update service</h3>
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
    </div>
    <div class="list">
        <form class="form" action="services" method="post" name="form">
            <input type="hidden" name="request" value="delete_service"/>
            <h3>Delete service</h3>
            <ul>
                <li>
                    <label for="delete_name">Name</label>
                    <input type="text" name="name" id="delete_name"/>
                </li>
            </ul>
            <button class="submit" type="submit">Delete service</button>
            <c:out value="${messages['delete_service']}"/>
        </form>
    </div>
    <div rel="main"></div>
</section>
<footer>
    <p>©2016 DreamTeam Ltd.<p>
</footer>
</body>
</html>