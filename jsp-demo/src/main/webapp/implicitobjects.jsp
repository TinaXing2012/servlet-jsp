<%--
  Created by IntelliJ IDEA.
  User: rujuanxing
  Date: 9/30/20
  Time: 8:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Implicit Object Demo</title>
</head>
<body>
<%
    pageContext.setAttribute("weather", "Rainy");
    String weather = (String) request.getAttribute("weather");
    String favorite_kpop_group = (String) session.getAttribute("favorite_kpop_group");
    String appName = (String) application.getAttribute("appName");
    System.out.println(pageContext.getAttribute("weather"));
    String channelName = config.getInitParameter("channelname");
    String author = config.getInitParameter("author");
    out.print(weather);
%>
<p>Weather: <%=weather%></p>
<p>favorite kpop group: <%=favorite_kpop_group%></p>
<p>appName: <%=appName%></p>
<p>channelName: <%=channelName%></p>
<p>author: <%=author%></p>
</body>
</html>
