package miss.xing;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class SignupServlet extends HttpServlet {

    public SignupServlet(){
        System.out.println("SignupServlet Constructor......");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init()....being called!");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>Current Time: " + LocalDateTime.now() + "</body></html>");
    }

    @Override
    public void destroy() {
        System.out.println("destory()... being called!");
    }
}
