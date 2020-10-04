<%@ page import="miss.xing.model.Employee" %>
<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: rujuanxing
  Date: 10/4/20
  Time: 10:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP EL [] Operator Demo</title>
</head>
<body>
<%
    pageContext.setAttribute("emp", new Employee("1003", "William", "Edward"));
    pageContext.setAttribute("foo.bar", "Sunday");
    pageContext.setAttribute("countries", Arrays.asList("US", "Canada", "China"));
%>
<p>Employee Info: ${emp["empId"]} - ${emp["firstName"]} - ${emp["lastName"]}</p>
<p>Today: ${pageScope["foo.bar"]}</p>
<p>${countries[0]} - ${countries["1"]}</p>
</body>
</html>
