<%@ page import="miss.xing.model.Person" %><%--
  Created by IntelliJ IDEA.
  User: rujuanxing
  Date: 10/12/20
  Time: 5:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>c:set and c:out</title>
</head>
<body>
<h1>c:set and c:out</h1>
<p>
    <c:set var="channelName" value="Miss Xing" scope="page" ></c:set>
    <c:out value="${channelName}"></c:out> <br/>
    <c:out value="${channelName1}" default="Default Value"></c:out> <br/>
    <c:out value="${channelName2}">Here is another way to set Default Value</c:out> <br/>
</p>
<p>
    Escape XML demo: <br/>
    <c:set var="paragraph" value="<p>This is Escape XML demo</p>"></c:set>
    <c:out value="${paragraph}"></c:out>
    <c:out value="${paragraph}" escapeXml="false"></c:out>
</p>

<p>
    Similar to jsp:setProperty <br/>

    <%
        Person p = new Person();
        request.setAttribute("person", p);
    %>
    <c:set value="William" property="firstName" target="${person}"></c:set>
    <c:set value="Edward" property="lastName" target="${person}"></c:set>

    <c:out value="${person}"></c:out> <br/>
    <c:out value="${person.firstName}"></c:out>
    <c:out value="${person.lastName}"></c:out>
</p>

</body>
</html>
