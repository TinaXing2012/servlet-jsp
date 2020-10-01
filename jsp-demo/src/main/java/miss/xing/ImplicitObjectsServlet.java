package miss.xing;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/implicitObj", initParams = {
        @WebInitParam(name = "channelname", value = "Miss Xing"),
        @WebInitParam(name = "author", value = "Tina")
})
public class ImplicitObjectsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("weather", "cloudy");
        req.getSession().setAttribute("favorite_kpop_group", "Twice");
        getServletContext().setAttribute("appName", "JSP Demo");
        req.getRequestDispatcher("implicitobjects.jsp").forward(req, resp);
    }
}
