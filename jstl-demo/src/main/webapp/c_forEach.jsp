<%@ page import="miss.xing.model.Person" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: rujuanxing
  Date: 10/12/20
  Time: 4:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<c:forEach var="i" begin="1" end="8">
    ${i}
</c:forEach>


<h1>Person List</h1>
<table>
    <tr>
        <th>Index</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Address</th>
    </tr>


    <c:forEach var="person" items="${people}" varStatus="status" step="1">
    <tr>
        <td>${status.count} - ${status.index}</td>
        <td>${person.firstName}</td>
        <td>${person.lastName}</td>
        <td>
<%--            <c:if test="${person.address == null}">--%>
<%--                No Address--%>
<%--            </c:if>--%>

<%--            <c:if test="${person.address != null}">--%>
<%--                ${person.address.street} ${person.address.city} ${person.address.state}--%>
<%--            </c:if>--%>

            <c:choose>
                <c:when test="${person.address == null}">
                    No Address
                </c:when>
                <c:otherwise>
                    ${person.address.street} ${person.address.city} ${person.address.state}
                </c:otherwise>
            </c:choose>
        </td>
    </tr>
    </c:forEach>

</table>
</body>
</html>
