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
    pageContext.setAttribute("weather", "Rainy"); //page scope
    String weather = (String) request.getAttribute("weather");
    String favorite_kpop_group = (String) session.getAttribute("favorite_kpop_group");
    String appName = (String) application.getAttribute("appName");

    String channelName = config.getInitParameter("channelname");
    String author = config.getInitParameter("author");
    out.print(weather);
    System.out.println("---------PageContext DEMO START-----------");
    System.out.println(pageContext.getAttribute("weather")); //Page Scope
    System.out.println(pageContext.getAttribute("weather", PageContext.REQUEST_SCOPE));
    System.out.println(pageContext.getAttribute("favorite_kpop_group", PageContext.SESSION_SCOPE));
    System.out.println(pageContext.getAttribute("appName", PageContext.APPLICATION_SCOPE));
    System.out.println("---------PageContext DEMO END-----------");

    pageContext.setAttribute("user", "Tina", PageContext.SESSION_SCOPE);
%>
<p>Weather: <%=weather%></p>
<p>favorite kpop group: <%=favorite_kpop_group%></p>
<p>appName: <%=appName%></p>
<p>channelName: <%=channelName%></p>
<p>author: <%=author%></p>
</body>
</html>
