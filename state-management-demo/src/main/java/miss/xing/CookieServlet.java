package miss.xing;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie user = new Cookie("user", "Tina");
        user.setMaxAge(10 * 60); //10 minutes
        resp.addCookie(user);


        Cookie playlist = new Cookie("playlist", "ServletNJSP");
        resp.addCookie(playlist);

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print("<html><body>");
        out.print("<a href=\"result\">Go to Result Servlet</a>");
        out.print("</body></html>");

    }
}
