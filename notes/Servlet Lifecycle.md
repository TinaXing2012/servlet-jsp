# Java/Jakarta Servlet Life cycle

A Servlet Life cycle is talking about the entire process from it's creation to the destruction.
Then who is maintaining life cycle of Servlets? There's no main() method in Servlets, so Web Container (Tomcat) takes care of the entire process.

In the following blog, I'll use Tomcat as web container.

The following are the paths went through by a servlet in web container:
1. After deploy servlet app in Tomcat, .class files will be loaded.
2. Tomcat creates servlet instance by using reflection API. Only one instance per servlet. By default, Tomcat instantiates servlet instance when the first request comes to the servlet. The <load-on-startup> attribute in web.xml or @WebServlet can be used to change to instantiate servlet during Tomcat startup.
3. The servlet's init() method will be called after instantiation. This method will be called only once in entire life cyle of servlet. And servlet cannot serve any request before init() method being called.
``` java
@Override
public void init(ServletConfig config) throws ServletException {
    //Put your Initialization code here
}
```
NOTE:
* How many times as init() being called? Only once. Zero could be a valid answer though, if no request comes to a servlet, by default, Tomcat won't instantiate it.
* Override init() method in our servlets? As your need.

4.Till now, Tomcat works as a container which holds all instances with servlet and knows which url maps to which servlet via web.xml or @WebServlet. 
When a request comes to Tomcat, Tomcat extracts requesting path from HTTP request, then delegates the request with a thread to the right servlet by calling servlet's service() method.
The service() method will call doGet(), doPost() or doXXX() method as appropriate based on HTTP request method(GET, POST, PUT, DELETE, etc.).
``` java
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();
        long lastModified;
        if (method.equals("GET")) {
            lastModified = this.getLastModified(req);
            if (lastModified == -1L) {
                this.doGet(req, resp);
            } else {
                long ifModifiedSince = req.getDateHeader("If-Modified-Since");
                if (ifModifiedSince < lastModified) {
                    this.maybeSetLastModified(resp, lastModified);
                    this.doGet(req, resp);
                } else {
                    resp.setStatus(304);
                }
            }
        } else if (method.equals("HEAD")) {
            lastModified = this.getLastModified(req);
            this.maybeSetLastModified(resp, lastModified);
            this.doHead(req, resp);
        } else if (method.equals("POST")) {
            this.doPost(req, resp);
        } else if (method.equals("PUT")) {
            this.doPut(req, resp);
        } else if (method.equals("DELETE")) {
            this.doDelete(req, resp);
        } else if (method.equals("OPTIONS")) {
            this.doOptions(req, resp);
        } else if (method.equals("TRACE")) {
            this.doTrace(req, resp);
        } else {
            String errMsg = lStrings.getString("http.method_not_implemented");
            Object[] errArgs = new Object[]{method};
            errMsg = MessageFormat.format(errMsg, errArgs);
            resp.sendError(501, errMsg);
        }

    }
```
NOTE:
* How many times are service() being called? As many times as many requests come.
* Override service() in our servlets? NO. The service() is fully implemented, and not recommended overriding unless you have a strong reason.

5.doGet(), doPost, doXXX() methods are the ones we override to implement business logic.
``` java
public class HelloWorldServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        PrintWriter out = resp.getWriter();
        out.println("Current Time: " + LocalDateTime.now());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // POST Request Logic code here
    }
}
```
NOTE:
* How many times are doXXX()() being called? As many times as many requests come.
* Override doXXX()() in our servlets? Absolutely 100%. Here are the place you implement business logic.

6.The destory() method is called only once at the end of the life cycle of a servlet.
 This method gives you a chance to close database connections, halt background threads, and perform other cleanup activities.
 After the destory() method is called, the servlet object is marked for garbage collection.
``` java
@Override
public void destroy() {
    //Your cleanup activities here
}
```
NOTE:
* How many times as init() being called? Only once. Zero could be a valid answer though, if no request comes to a servlet, by default, Tomcat won't instantiate it.
* Override destory() method in our servlets? As your need.
