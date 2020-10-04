<%--
  Created by IntelliJ IDEA.
  User: rujuanxing
  Date: 10/3/20
  Time: 9:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${firstThing.secondThing} - firstThing is EL Implicit Object</title>
</head>
<body>
<%
        pageContext.setAttribute("username", "Tina");
%>
<p>Page Scope: ${pageScope.username}</p>
<p>Request Scope: ${requestScope.username}</p>
<p>Session Scope: ${sessionScope.username}</p>
<P>Application Scope: ${applicationScope.username}</P>
</body>
</html>
