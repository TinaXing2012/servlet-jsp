<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: rujuanxing
  Date: 10/16/20
  Time: 8:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>JSTL Formatting Tag Library Demo</title>
</head>
<body>
<c:set var="amount" value="5728.9869"></c:set>
<fmt:parseNumber value="${amount}" integerOnly="true"/> <br/>
<fmt:parseNumber value="${amount}" type="number"></fmt:parseNumber> <br/>

<fmt:formatNumber value="${amount}" type="currency"/> <br/>
<fmt:setLocale value="zh_CN"></fmt:setLocale>
<fmt:formatNumber value="${amount}" type="currency"/> <br/>

<c:set var="today" value="16-10-2020"/>
<fmt:parseDate value="${today}" pattern="dd-MM-yyyy"/><br/>

<fmt:setLocale value="en_US"></fmt:setLocale>
<%--<c:set var="now" value="<%=LocalDateTime.now()%>"/>--%>
<c:set var="now" value="<%= new Date()%>"/>
<fmt:formatDate value="${now}" type="time" /><br/>
</body>
</html>
