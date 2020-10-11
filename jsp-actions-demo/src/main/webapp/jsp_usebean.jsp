<%@ page import="miss.xing.model.Person" %><%--
  Created by IntelliJ IDEA.
  User: rujuanxing
  Date: 10/10/20
  Time: 8:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>The jsp:useBean Action</title>
</head>
<body>
<p>1. Locate an existing Bean in page, request, session or application scope.</p>
<%
    Person p = new Person("Tina", "Xing");
    request.setAttribute("person", p);
%>

<jsp:useBean id="person" class="miss.xing.model.Person" scope="request"></jsp:useBean>

<jsp:getProperty name="person" property="firstName"/>
<jsp:getProperty name="person" property="lastName"/>

<p>2. Create a Bean</p>
<jsp:useBean id="person2" type="miss.xing.model.Person" class="miss.xing.model.Employee">

</jsp:useBean>
<%--<jsp:useBean id="person2" type="miss.xing.model.Employee" beanName="miss.xing.model.Employee"></jsp:useBean>--%>

<jsp:getProperty name="person2" property="firstName"/>
<jsp:getProperty name="person2" property="lastName"/>
<jsp:getProperty name="person2" property="salary"/>

</body>
</html>
