<%--
  Created by IntelliJ IDEA.
  User: rujuanxing
  Date: 10/4/20
  Time: 10:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP EL Arithmetic, Logical, Relational Operators Demo</title>
</head>
<body>
<%
    pageContext.setAttribute("isLoggedIn", true);
    pageContext.setAttribute("isAdmin", false);
%>
<p>EL Arithmetic Operators: ${2+3}, ${7 * 8}</p>
<p>EL Logical Operators: ${isLoggedIn and isAdmin}</p>
<p>EL Relational Operators: ${2 > 3}</p>

</body>
</html>
