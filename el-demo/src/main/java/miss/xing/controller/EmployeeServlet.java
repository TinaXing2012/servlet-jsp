package miss.xing.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import miss.xing.model.Address;
import miss.xing.model.Employee;

import java.io.IOException;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee employee = new Employee("1001", "Tina", "Xing");
        Address address = new Address("1000 N 4th ST", "Fairfield", "Iowa");
        employee.setAddress(address);
        req.setAttribute("emp", employee);

        Employee employee2 = new Employee("1002", "Rujuan", "Xing");
        req.setAttribute("emp2", employee2);
        req.getRequestDispatcher("emp.jsp").forward(req, resp);
    }
}
