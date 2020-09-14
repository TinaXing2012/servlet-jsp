package miss.xing;

import miss.xing.container.HttpServlet;
import miss.xing.container.Request;
import miss.xing.container.Response;

import java.io.PrintWriter;

public class HelloWorldServlet extends HttpServlet {

    @Override
    public void init() {
        System.out.println("HelloWorldServlet init() called.....");
    }

    @Override
    public void doGet(Request request, Response response) {
        PrintWriter out = response.getPrintWriter();
        out.println("<html><body>");
        out.println("doGet() in HelloWorldServlet");
        out.println("</body></html>");
    }
}
