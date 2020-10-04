package miss.xing.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/operator")
public class OperatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("username", "Josh");
//        req.getSession().setAttribute("username", "Ella");
//        getServletContext().setAttribute("username", "Alice");
        req.getRequestDispatcher("singleword.jsp").forward(req, resp);
    }
}
