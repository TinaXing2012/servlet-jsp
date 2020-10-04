<%--
  Created by IntelliJ IDEA.
  User: rujuanxing
  Date: 10/3/20
  Time: 5:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="true" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<p><a href="employee">Display Employee Info</a></p>
<p><a href="operator">Demo for - ${something}</a></p>
<p><a href="implicitObject">${firstThing.secondThing} - firstThing is EL Implicit Object</a> </p>
<p><a href="paramimplicitobj.jsp?username=Rujuan&password=123456">EL param Implicit Object</a> </p>
<p><a href="cookie">EL cookie Implicit Object</a> </p>
<p><a href="employee">Display Employee Info</a></p>
</body>
</html>
