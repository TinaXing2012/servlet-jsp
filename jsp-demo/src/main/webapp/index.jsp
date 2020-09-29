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
</body>
</html>
