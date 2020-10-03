<%@ page import="miss.xing.model.Employee" %>
<%@ page import="miss.xing.model.Address" %><%--
  Created by IntelliJ IDEA.
  User: rujuanxing
  Date: 10/3/20
  Time: 5:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Info</title>
</head>
<body>
<h1>1. Scriptlet</h1>
<%
    Employee emp = (Employee) request.getAttribute("emp");
    out.println("First Name: " + emp.getFirstName());
%>
    <br/>
<%
    out.println("Last Name: " + emp.getLastName());
    out.write("<br/>");
    Address address = emp.getAddress();
    out.println(address.getStreet() + " " + address.getCity() +", " + address.getState());
%>

<h1>2. JSP Expression</h1>
<p>First Name: <%= emp.getFirstName()%></p>
<p>Last Name: <%= emp.getLastName()%></p>
<p>Address:</p>
<p>Street: <%= ((Employee)request.getAttribute("emp")).getAddress().getStreet()%></p>
<p>City: <%= ((Employee)request.getAttribute("emp")).getAddress().getCity()%></p>
<p>State: <%= ((Employee)request.getAttribute("emp")).getAddress().getState()%></p>

<h1>3. Expression Language in JSP</h1>
<p>First Name: ${emp2.firstName}</p>
<p>Last Name: ${emp2.lastName}</p>
<p>Address:</p>
<p>Street: ${emp2.address.street}</p>
<p>City: ${emp2.address.city}</p>
<p>State: ${emp2.address.state}</p>
</body>
</html>
