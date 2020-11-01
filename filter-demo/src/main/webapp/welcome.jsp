<%--
  Created by IntelliJ IDEA.
  User: rujuanxing
  Date: 10/20/20
  Time: 9:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h1>Welcome, ${username}</h1>
<p>Request Attribute ${handsomeguy}</p>

<form action="logout" method="post">
    <input type="submit" value="logout">
</form>

</body>
</html>
