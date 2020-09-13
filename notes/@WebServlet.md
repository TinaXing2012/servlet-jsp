# @WebServlet

The @WebServlet annotation declares a Servlet, but it must annotate classes which extend jakarta.servlet.http.HttpServlet or javax.servlet.http.HttpServlet.

## Attributes of @WebServlet Annotations

| Attribute Name    | Type          | Required      | Description |   Example |
| ----------------- | ------------- |-------------  | -----------  |-----------  |
| value  or urlPatterns | String[]  |Required       | Specify one or more URL patterns of the servlet. Either of attribute can be used, but not both. value must start with "/" |@WebServlet(urlPatterns = {"/sendFile", "/uploadFile"}) or @WebServlet({"/sendFile", "/uploadFile"}) or @WebServlet(value = {"/sendFile", "/uploadFile"})|
| initParams        | WebInitParam[]|Optional       | Specify one or more initialization parameters of the servlet. Each parameter is specified by @WebInitParam annotation type. |@WebServlet(urlPatterns = "/imageUpload",initParams ={@WebInitParam(name = "saveDir", value = "D:/FileUpload"),@WebInitParam(name = "allowedTypes", value = "jpg,jpeg,gif,png")})|
| name              | String        |Optional       | Name of the servlet        | @WebServlet(name="helloworld", value="/hello") |
| displayName       | String        |Optional       | Display name of the servlet| @WebServlet(displayName="helloworld", urlPatterns="/hello") |
| description       | String        |Optional       | Description of the servlet | @WebServlet(description="helloworld", urlPatterns="/hello") |
| asyncSupported    | boolean       |Optional       | Specify whether the servlet supports asynchronous operation mode. Default is false. | @WebServlet(asyncSupported=true, urlPatterns="/hello") |
| loadOnStartup     | int           | Optional      | Specify load-on-startup order of the servlet. default value is -1. |@WebServlet(loadOnStartup=1, urlPatterns="/hello") |
| smallIcon         | String        | Optional      | Specify name of the small icon of the servlet. |TODO|
| largeIcon         | String        | Optional      | Specify name of the large icon of the servlet. |TODO |
 
NOTE: the attributes displayName, description, smallIcon and largeIcon are primarily used by tools, IDEs or servlet containers, they do not affect operation of the servlet.

## Can @WebServlet and web.xml stay together?
Yes, you can have web.xml and @WebServlet both existing in the same project. 
But you CANNOT use both ways to declare a servlet which means you either declare Servlet in web.xml or use @WebServlet annotation.
Otherwise, you'll get Exception while deploying your project to web container.

## The value of @WebServlet urlPatterns attribute?
In a project, you CANNOT specify the same URL patterns for different servlets. you'll get Exception while deploying your project to web container.
While you specify value using @WebServlet, the value must start with "/", otherwise, you know now, exception while deploying project.



Reference:
https://www.codejava.net/java-ee/servlet/webservlet-annotation-examples