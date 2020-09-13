# All about web.xml

## What is web.xml?

The web.xml file resides in the application's WAR file under WEB-INF/ directory.

Web containers such as Tomcat use this file as a deployment descriptor to determine how URLs are map to servlets, welcome list and others.

1. Below is an example of web.xml which configured servlet and URL paths.

```xml
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
         http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
         version="3.1">
    <servlet>
        <servlet-name>helloworld</servlet-name>
        <servlet-class>miss.xing.HelloWorldServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>helloworld</servlet-name>
        <url-pattern>/hello</url-pattern>
    </servlet-mapping>
</web-app>
```

2. Mapping to JSP example. I didn't use this kind of settings before. For this case, I always forward via Servlet.
```xml
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
         http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
         version="3.1">
        <servlet>
            <servlet-name>signup</servlet-name>
            <jsp-file>/signup/signup.jsp</jsp-file>
        </servlet>
    
        <servlet-mapping>
            <servlet-name>signup</servlet-name>
            <url-pattern>/signup/*</url-pattern>
        </servlet-mapping>

</web-app>
```

3. Welcome file list. The deployment descriptor can specify a list of filenames that the server should try when the user accesses a path that represents a WAR subdirectory that is not already explicitly mapped to a servlet. The servlet standard calls this the "welcome file list."
Tomcat also has default welcome file list. If we didn't specify in our application, it'll use the default settings in Tomcat.
```xml
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
         http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
         version="3.1">

         <welcome-file-list>
                <welcome-file>index.jsp</welcome-file>
                <welcome-file>index.html</welcome-file>
         </welcome-file-list>

</web-app>
```

4. TODO: More can be configured in web.xml, add later...

## Why web.xml isn’t popular?

XML was used to transfer content over the network. Since JSON is available, XML became less appeal.
The same amount content to be carried by XML and JSON, the JSON's load is much smaller than XML's.
And to extract info from XML is much more difficult compared from JSON.

Over the time, once popular XML configuration lost its appeal and popularity in favor of Java-based annotation configuration and Java class as configuration file.


## Is web.xml file mandatory in Servlet application?
No. From Java Servlet 3.0, web.xml is not mandatory which can be replaced using Annotations.

But, annotations cannot do everything, there are certain things if you still need to use web.xml to configure, because they're not achievable via Annotations.
Let's see some of them:
1. context parameters.
2. Specify filter orders. The filters are applied based on the order they located in the source code of web.xml (also need to consider URL pattern).
3. To define a session timeout, we still need to use the <session-config>.
4. To define welcome file list, still need <welcome-file-list> tag.
As you can see, those settings are kind of global settings of an application. Annotations must be applied on specific servlet, filter or listener. That's why annocation cannot do.

From Servlet 3.0, you can also programmatically configure those via ServletContainerInitializer to configure some of them.

