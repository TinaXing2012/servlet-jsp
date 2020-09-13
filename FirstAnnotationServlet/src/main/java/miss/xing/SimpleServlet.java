package miss.xing;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/hello") //THis is to set "hello" to value attribute
//@WebServlet(value = "/hello") //this is the same as previous one.
//@WebServlet(urlPatterns = "/hello")
//@WebServlet({"/hello", "/simple"})
@WebServlet(urlPatterns = {"/hello", "/simple", "/world"})
public class SimpleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("Hello from Tina");
        out.println("</body></html>");
    }
}
