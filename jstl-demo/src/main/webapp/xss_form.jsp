<%--
  Created by IntelliJ IDEA.
  User: rujuanxing
  Date: 10/12/20
  Time: 9:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>XSS Form</title>
</head>
<body>

<form action="xss" method="post">
    <textarea name="blog"></textarea>
    <input type="submit" value="Submit">
</form>

</body>
</html>
