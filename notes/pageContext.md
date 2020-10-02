# JSP Implicit Object - pageContext

In JSP, pageContext is an implicit object of type PageContext class.The pageContext object can be used to set,get or remove attribute from one of the following scopes:
* page [PageContext.PAGE_SCOPE] - This is default scope
* request [PageContext.REQUEST_SCOPE]
* session [PageContext.SESSION_SCOPE]
* application [PageContext.APPLICATION_SCOPE]

## Example
Use pageContext to set Attribute
```jsp
<%
    pageContext.setAttribute("weather", "Rainy"); //page scope
    pageContext.setAttribute("user", "Tina", PageContext.SESSION_SCOPE); //Session Scope
%>
```

Use pageContext to get Attribute
```jsp
<%
    String name = (String) pageContext.getAttribute("user", PageContext.SESSION_SCOPE);
    out.print("User: ");
    out.print(name);
     
    System.out.println(pageContext.getAttribute("weather")); //Page Scope
    System.out.println(pageContext.getAttribute("weather", PageContext.REQUEST_SCOPE));
    System.out.println(pageContext.getAttribute("favorite_kpop_group", PageContext.SESSION_SCOPE));
    System.out.println(pageContext.getAttribute("appName", PageContext.APPLICATION_SCOPE));
%>
```
