<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file="../css/main.css"%>
    </style>
    <title>Order</title>
</head>
<body>
<header>
    <h1>Order</h1>
</header>
<nav class="button_list">
    <a href="/projectx/dashboard"><button>Dashboard</button></a>
</nav>
<section class="wrap">
    <div class="observ">
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
    </div>
    <div class="observ">
        <h2>Orders</h2>
        <table>
            <thead>
            <tr>
                <th>Order ID</th>
                <th>Order date</th>
                <th>Event date</th>
                <th>Service name</th>
                <th>User</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach  var="order" items="${orders}">
                <tr>
                    <td><c:out value="${order.id}" /></td>
                    <td><c:out value="${order.orderDate}" /></td>
                    <td><c:out value="${order.eventDate}" /></td>
                    <td><c:out value="${order.service}" /></td>
                    <td><c:out value="${order.user}" /></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="list">
        <form class="form" action="order" method="post" name="form">
            <input type="hidden" name="request" value="add_order"/>
            <h2>Add order</h2>
            <ul>
                <li>
                    <label for="add_name">Service name</label>
                    <input type="text" name="name" id="add_name"/>
                </li>
                <li>
                    <label for="add_date">Event date</label>
                    <input type="text" name="date" id="add_date"/>
                </li>
            </ul>
            <button class="submit" type="submit">Add order</button>
            <c:out value="${messages['add_order']}"/>
        </form>
    </div>
    <div class="list">
        <form class="form" action="order" method="post" name="form">
            <input type="hidden" name="request" value="update_order"/>
            <h3>Update order</h3>
            <ul>
                <li>
                    <label for="update_id">Order ID</label>
                    <input type="text" name="id" id="update_id"/>
                </li>
                <li>
                    <label for="update_order_date">Order date</label>
                    <input type="text" name="order_date" id="update_order_date"/>
                </li>
                <li>
                    <label for="update_event_date">Event date</label>
                    <input type="text" name="event_date" id="update_event_date"/>
                </li>
                <li>
                    <label for="update_service_name">Service name</label>
                    <input type="text" name="service_name" id="update_service_name"/>
                </li>
                <li>
                    <label for="update_login">User login</label>
                    <input type="text" name="login" id="update_login"/>
                </li>
            </ul>
            <button class="submit" type="submit">Update order</button>
            <c:out value="${messages['update_order']}"/>
        </form>
    </div>
    <div class="list">
        <form class="form" action="order" method="post" name="form">
            <input type="hidden" name="request" value="delete_order"/>
            <h3>Delete order</h3>
            <ul>
                <li>
                    <label for="delete_id">Order ID</label>
                    <input type="text" name="id" id="delete_id"/>
                </li>
            </ul>
            <button class="submit" type="submit">Delete order</button>
            <c:out value="${messages['delete_order']}"/>
        </form>
    </div>
    <div rel="main"></div>
</section>
<footer>
    <p>©2016 DreamTeam Ltd.<p>
</footer>
</body>
</html>
