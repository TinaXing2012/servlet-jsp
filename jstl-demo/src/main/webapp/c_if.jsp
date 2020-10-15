<%--
  Created by IntelliJ IDEA.
  User: rujuanxing
  Date: 10/15/20
  Time: 5:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>c:if Demo</title>
</head>
<body>
<c:set var="age" value="70" />
<c:if test="${age > 65}">
    <p>Retired: Age > 65</p>
</c:if>

<c:if test="${! (age <= 65)}">
    <p>Retired: Age > 65</p>
</c:if>

<c:if test="${age > 30}" var="result" scope="request"></c:if>
<p>c:if Result:
    <c:out value="${requestScope.result}"></c:out>
</p>
<p>c:if result: ${result}</p>

</body>
</html>
