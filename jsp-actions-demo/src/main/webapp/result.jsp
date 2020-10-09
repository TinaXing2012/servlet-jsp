<%--
  Created by IntelliJ IDEA.
  User: rujuanxing
  Date: 10/8/20
  Time: 9:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<h1>This is result Page</h1>
${param["channel"]} ---- ${param["author"]}
<p>
    <%=request.getParameter("channel")%> =====
    <%=request.getParameter("author")%>
</p>

<p>
    <%
        out.print(request.getParameter("channel"));
        out.print("<br/>");
        out.print(request.getParameter("author"));
    %>
</p>
</body>
</html>
