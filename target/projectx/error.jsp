<%--
  Created by IntelliJ IDEA.
  User: roski
  Date: 4/27/16
  Time: 8:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<header>
    <h1>Sorry for error</h1>
</header>
<nav>
    <a href="/projectx/">
        <button>Main page</button>
    </a>
</nav>
<section>
    <h2>
        Error:
        <c:out value="${error}"/>
    </h2>
</section>
<footer>
    <p>©2016 DreamTeam Ltd.<p>
</footer>
</body>
</html>
