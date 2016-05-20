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
    <% String username = ((User) session.getAttribute("user")).getUsername();%>
    It's a dashboard. Hi, <%=username%> !
</body>
</html>
