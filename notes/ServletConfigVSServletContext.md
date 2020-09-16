# ServletConfig VS ServletContext

## ServletConfig
* One ServletConfig Object per Servlet
* Parameters are configured in DD or @WebServlet
* Parameter values are String type
* Can be used to pass deploy-time information to Servlet

### XML configuration style
```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <web-app version="4.0" xmlns="http://xmlns.jcp.org/xml/ns/javaee"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
     http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd">
    
    <servlet>
      <servlet-name>initParams</servlet-name>
      <servlet-class>miss.xing.InitParamtersServlet</servlet-class>
      <init-param>
        <param-name>title</param-name>
        <param-value>ServletConfigDemo</param-value>
      </init-param>
      <init-param>
        <param-name>configstyle</param-name>
        <param-value>DD</param-value>
      </init-param>
    </servlet>
    
    <servlet-mapping>
      <servlet-name>initParams</servlet-name>
      <url-pattern>/</url-pattern>
    </servlet-mapping>

  </web-app>
```
```java
public class InitParamtersServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        Enumeration<String> names = config.getInitParameterNames();
        String name = null;
        while (names.hasMoreElements()) {
            name = names.nextElement();
            System.out.println(name + ": " + config.getInitParameter(name));
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("Servlet Init Paramters <br/>");
        out.println("title: " + getInitParameter("title"));
        out.println("<br/>");
        out.println("configstyle: " + getInitParameter("configstyle"));       
    }
}
```
NOTE:
* When override init(), you must call "super.init(config)" to set ServletConfig value. 
  Otherwise, in doGet and other doXXX() methods, the ServletConfig will hold null value which means all methods under ServletConfig are NOT working.
  You won't run this issue if you don't override init().
  
### Annotation configuration style
```java
@WebServlet(urlPatterns = "/initParamsAnnotation", initParams = {
        @WebInitParam(name = "title", value = "ServletConfig Init Params Annocation Demo"),
        @WebInitParam(name = "configstyle", value = "annotaion")
})
public class InitParamsAnnotationStyleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("Servlet Init Paramters Annocation Style<br/>");
        out.println("title: " + getInitParameter("title"));
        out.println("<br/>");
        out.println("configstyle: " + getInitParameter("configstyle"));
    }
}
```

## ServletContext
* One ServletContext per web appplication. This is really not a good name, because this object is for entire application, not related to particular servlet.
* Can be used to set application-wide deploy-time information.
* Available at application level in every servlet, filter,etc.
* The only way to config is XML, cannot use annotation. Think about it, annotation must be applied on a specific servlet. But ServletContext is used for entire application, not only 1 servlet.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app version="4.0" xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
   http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd">

  <context-param>
    <param-name>author</param-name>
    <param-value>Tina</param-value>
  </context-param>
  <context-param>
    <param-name>country</param-name>
    <param-value>China</param-value>
  </context-param>

</web-app>
```

```java
public class InitParamsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("ServletContext Paramters Only XML Style<br/>");
        out.println("author: " + getServletContext().getInitParameter("author"));
        out.println("<br/>");
        out.println("country: " + getServletContext().getInitParameter("country"));
    }
}
```


