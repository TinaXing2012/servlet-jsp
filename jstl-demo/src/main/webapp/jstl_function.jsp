<%--
  Created by IntelliJ IDEA.
  User: rujuanxing
  Date: 10/15/20
  Time: 9:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL Function Tag Library</title>
</head>
<body>
<c:set var="greeting" value="Welcome to my Channel, This is an awesome channel from Miss Xing"></c:set>
<c:if test="${fn:contains(greeting, 'awesome')}">
    <p>The greeting string contains 'awesome'.</p>
</c:if>

<c:if test="${fn:containsIgnoreCase(greeting, 'AwEsOme')}">
    <p>The greeting string contains 'AwEsOme'.</p>
</c:if>

<c:if test="${fn:indexOf(greeting, 'Xing') > -1}">
    <p>The greeting string contains 'Xing'</p>
</c:if>

<c:set var="playlist" value="This is Jakarta Servlet       playlist     "></c:set>
${fn:trim(playlist)}
<br/>
<c:set var="size" value="x-small,small,medium,large,x-large"></c:set>
<c:set var="sizeArr" value="${fn:split(size, ',')}"></c:set>
<c:forEach var="s" items="${sizeArr}">
    ${s} <br/>
</c:forEach>
<p>Substring: ${fn:substring(playlist, 3, fn:indexOf(playlist, 'e'))}</p>


</body>
</html>
