<%--
  Created by IntelliJ IDEA.
  User: rujuanxing
  Date: 10/4/20
  Time: 10:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP EL Reserved Word Demo</title>
</head>
<body>

<%
    pageContext.setAttribute("and", "This is a value");
%>

<p>Reserve word: ${pageScope["and"]}</p>
</body>
</html>
