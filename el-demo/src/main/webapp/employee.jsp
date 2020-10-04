<%--
  Created by IntelliJ IDEA.
  User: rujuanxing
  Date: 10/3/20
  Time: 9:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP EL Dot (.) Operator Demo - firstThing is an attribute in one scope</title>
</head>
<body>
<h1>Employee 1</h1>
<p>${emp.empId} - ${emp.firstName} - ${emp.lastName}</p>
<p>Address: ${emp.address.street} ${emp.address.city}, ${emp.address.state}</p>
<p>Address: ${emp.address}</p>

<h1>Employee 2</h1>
<p>${emp2.empId} - ${emp2.firstName} - ${emp2.lastName}</p>
<p>Address: ${emp2.address.street} ${emp2.address.city}, ${emp2.address.state}</p>
</body>
</html>
