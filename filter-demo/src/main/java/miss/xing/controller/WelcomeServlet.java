package miss.xing.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//@WebServlet(name = "welcomeservlet", urlPatterns = {"/", "/web/welcome/abc"})
public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("WelcomeServlet doGet()...");
        System.out.println(req.getAttribute("handsomeguy"));
        resp.setContentType("text/plain");
//        resp.getWriter().println("This is WelcomeServlet doGet()!!!");
//        req.getRequestDispatcher("welcome.jsp").forward(req, resp);
//        req.getRequestDispatcher("welcome.jsp").include(req, resp);
        resp.getWriter().println("This is WelcomeServlet doGet()!!!");
    }
}
