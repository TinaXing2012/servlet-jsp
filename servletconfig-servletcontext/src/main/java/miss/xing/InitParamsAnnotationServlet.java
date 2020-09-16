package miss.xing;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/initParamsAnnotation", initParams = {
    @WebInitParam(name="title", value = "Init Parameters Annotation Demo"),
    @WebInitParam(name="configStyle", value = "Annotation")
})
public class InitParamsAnnotationServlet extends HttpServlet {

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
