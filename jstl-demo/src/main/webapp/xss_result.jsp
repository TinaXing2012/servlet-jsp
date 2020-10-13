<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: rujuanxing
  Date: 10/12/20
  Time: 9:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>XSS Result - Blog List</title>
</head>
<body>
<%
    List<String> blogs = (List<String>) request.getAttribute("blogs");
    for(String blog: blogs){
        pageContext.setAttribute("myblog", blog);
%>

<c:out value="${myblog}"></c:out>
<%
    }
%>
</body>
</html>
