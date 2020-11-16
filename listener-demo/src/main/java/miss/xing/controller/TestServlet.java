package miss.xing.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        PrintWriter out = resp.getWriter();
        Connection connection = (Connection) req.getServletContext().getAttribute("dbconnection");
        try {
            PreparedStatement statement = connection.prepareStatement("select * from book");
            ResultSet rs = statement.executeQuery();
            while(rs != null && rs.next()){
                out.println(rs.getString("isbn") +"-----" + rs.getString("title"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        out.println("This is for test Purpose");
    }
}
