<%--
  Created by IntelliJ IDEA.
  User: rujuanxing
  Date: 10/15/20
  Time: 8:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>c:url, c:param Demo</title>
</head>
<body>
<ul>
    <li>
        <c:url var="indexURL" value="index.jsp" scope="request"></c:url>
        <a href="${indexURL}">Index.jsp</a>
    </li>
    <li>
        <a href="<c:url value="index.jsp"/>">Index.jsp</a>
    </li>
    <c:set var="firstName" value="Tina" scope="request"></c:set>
    <c:set var="lastName" value="Xing" scope="request"></c:set>
    <li>
        <a href="user/profile/profile.jsp?firstName=${firstName}&lastName=${lastName}">Profile.jsp</a>
    </li>
    <li>
        <c:url var="profileUrl" value="user/profile/profile.jsp">
            <c:param name="firstName" value="${firstName}"></c:param>
            <c:param name="lastName" value="${lastName}"></c:param>
        </c:url>
        <a href="${profileUrl}">Profile.jsp</a>
    </li>
    <li>
        <!--http://localhost:8080/index.jsp-->
        <a href="/index.jsp">Doesn't work with leading slash</a>
    </li>
    <li>
        <!--http://localhost:8080/jstl_demo_war_exploded-->
        <a href="<c:url value="/index.jsp"></c:url>">Works with leading slash when c:url</a>
    </li>
</ul>
</body>
</html>
