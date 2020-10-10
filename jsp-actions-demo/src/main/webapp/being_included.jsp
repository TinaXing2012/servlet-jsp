<%--
  Created by IntelliJ IDEA.
  User: rujuanxing
  Date: 10/9/20
  Time: 8:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>This Page is included inside jsp_include.jsp</title>
</head>
<body>
<%
    out.print(2+4);
    out.print("<p>The answer is 6</p>");
    System.out.println("being_include.jsp is executed.........");
%>

<p>${param.channel} --- ${param.author}</p>
</body>
</html>
