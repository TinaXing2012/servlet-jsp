<%--
  Created by IntelliJ IDEA.
  User: rujuanxing
  Date: 10/4/20
  Time: 11:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL is “null friendly”</title>
</head>
<body>

<p>Fails sliently: ${emp.firstName}</p>
<p>In arithmetic expression, treats null value as 0: ${100 * emp.salary}</p>
<p>In logical expression, treats null as false: ${true && emp.salay}</p>

</body>
</html>
