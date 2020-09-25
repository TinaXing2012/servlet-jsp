package miss.xing;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import miss.xing.model.User;

import java.io.IOException;

@WebServlet("/attributedemo")
public class AttributeDemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //HttpServletRequest
        //HttpSession
        //ServletContext

        req.setAttribute("channelName", "Miss Xing");
        String name = (String) req.getAttribute("channelName");
        req.removeAttribute("channelName");

        HttpSession session = req.getSession();
        session.setAttribute("user", new User("Tina", "Xing"));
        User user = (User) session.getAttribute("user");


        ServletContext context = this.getServletContext();
        context.setAttribute("user2", new User("Tina2", "Xing2"));
        User user2 = (User) context.getAttribute("user2");
        context.removeAttribute("user2");


    }
}
