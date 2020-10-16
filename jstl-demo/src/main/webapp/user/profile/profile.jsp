<%--
  Created by IntelliJ IDEA.
  User: rujuanxing
  Date: 10/15/20
  Time: 8:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<p>First Name: ${param.firstName} </p>
<p>Last Name: ${param.lastName}</p>

<!--
http://localhost:8080/jstl_demo_war_exploded/user/profile/profile.jsp?firstName=Tina&lastName=Xing
http://localhost:8080/jstl_demo_war_exploded/c_url.jsp

http://localhost:8080/jstl_demo_war_exploded
-->

<p><a href="../../c_url.jsp">c_url.jsp</a> </p>
<p>
    <c:url var="curl" value="/c_url.jsp"></c:url>
    <a href="${curl}">c_url.jsp with c:url generated URL</a>
</p>

</body>
</html>
