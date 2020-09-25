package miss.xing;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import miss.xing.model.User;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        PrintWriter out = resp.getWriter();

        String playlist = (String) req.getAttribute("playlist");
        User user = (User) req.getAttribute("user");
        System.out.println(user.getFirstName());

        out.println("playlist: " + playlist);
        out.println("user: " + user.getFirstName() + " " + user.getLastName());


    }
}
