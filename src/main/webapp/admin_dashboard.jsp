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
    <% String username = ((User) session.getAttribute("user")).getUsername();%>
    It's a admin dashboard. Hi, <%=username%> !
</body>
</html>
