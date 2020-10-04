<%@ page import="java.time.LocalDateTime, java.time.LocalDate" %>

<%--
  Created by IntelliJ IDEA.
  User: rujuanxing
  Date: 9/28/20
  Time: 5:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<p><a href="lifecycledemo.jsp">JSP Life CyCle Demo</a> </p>
<%@ include file="header.jsp"%>

<h1>Welcome to Miss Xing channel! Please like and subscribe!!!</h1>
<h2>Declaration: used to insert instance variables and methods into generated servlet class</h2>
<%!
    int count = 0;

    public int getCount(){
        return count;
    }
%>

<h2>Scriptlet: all statements will be inserted into _jspService()</h2>
<%
    int count = 0;
    count++;
    System.out.println("count: " + count);
    System.out.println("getCount(): " + getCount());
%>

<h2>Expression: the thing you put between the tags, are wrapped in out.print() under _jspService()</h2>

<%= count %>
<%= getCount()%>

<h2>Directive: Page Directive</h2>
<%
    LocalDate currentDate = LocalDate.now();
    LocalDateTime currentTime = LocalDateTime.now();
%>
<p>Today is  <%=currentDate%> </p>
<p>Current Time is <%=currentTime%></p>

<!-- HTML Comment -->

<%-- JSP Comment --%>

<%
    String name = (String) pageContext.getAttribute("user", PageContext.SESSION_SCOPE);
    out.print("User: ");
    out.print(name);
%>

<%@include file="footer.jsp"%>
</body>
</html>
