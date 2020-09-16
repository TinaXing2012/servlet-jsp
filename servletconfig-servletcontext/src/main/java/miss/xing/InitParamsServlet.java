package miss.xing;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class InitParamsServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("title: " + config.getInitParameter("title"));
        System.out.println("configStyle: " + config.getInitParameter("configStyle"));
        System.out.println("Author: " + config.getServletContext().getInitParameter("author"));
        System.out.println("Country: " + config.getServletContext().getInitParameter("country"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        System.out.println("ServletConfig: " + getServletConfig());
        out.println("<html><body>");
        out.println("title: " + getServletConfig().getInitParameter("title"));
        out.println("<br>");
        out.println("config style: " + getInitParameter("configStyle"));
        out.println("<br>");
        out.println("Application Context Parameters <br>");
        out.println("Author: " + getServletContext().getInitParameter("author"));
        out.println("<br>");
        out.println("Country: " + getServletContext().getInitParameter("country"));
        out.println("</body></html>");
    }
}
