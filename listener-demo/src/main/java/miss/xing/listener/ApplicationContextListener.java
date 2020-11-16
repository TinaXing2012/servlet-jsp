package miss.xing.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import miss.xing.db.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;

@WebListener
public class ApplicationContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");
        String driver = context.getInitParameter("driver");
        String dburl = context.getInitParameter("dburl");

        try {
            DatabaseConnectionManager dbManager = new DatabaseConnectionManager(username, password, driver, dburl);
            Connection connection = dbManager.getConnection();
            context.setAttribute("dbconnection", connection);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
       Connection connection = (Connection) sce.getServletContext().getAttribute("dbconnection");
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
