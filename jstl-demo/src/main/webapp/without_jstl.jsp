<%@ page import="miss.xing.model.Person" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: rujuanxing
  Date: 10/12/20
  Time: 4:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Person List</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Address</th>
    </tr>

    <%
        List<Person> personList = (List<Person>) request.getAttribute("people");
        for(Person p : personList){
    %>
    <tr>
        <td><%= p.getFirstName()%></td>
        <td><%= p.getLastName()%></td>
        <td>
            <%
                if(p.getAddress() == null){
                    out.print("No Address");
                } else {

            %>
            <%= p.getAddress().getStreet()%> <%= p.getAddress().getCity()%> <%= p.getAddress().getState()%>
            <%}%>
        </td>
    </tr>

    <%
        }
    %>
</table>
</body>
</html>
