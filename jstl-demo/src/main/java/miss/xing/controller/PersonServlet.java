package miss.xing.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import miss.xing.model.Address;
import miss.xing.model.Person;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/person")
public class PersonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Person> personList = Arrays.asList(
                new Person("William", "Edward"),
                new Person("Lily", "Happy", new Address("9858 Happy Dr", "Fairfield", "CA")),
                new Person("Bella", "Xing", new Address("1000 N 4th", "Fairfield", "IA"))
        );
        req.setAttribute("people", personList);
        req.getRequestDispatcher("without_jstl.jsp").forward(req, resp);

    }
}
