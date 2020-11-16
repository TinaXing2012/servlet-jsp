package miss.xing.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionManager {

    private Connection connection;

    public DatabaseConnectionManager(String username, String password, String driver, String dburl) throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        this.connection = DriverManager.getConnection(dburl, username, password);
    }

    public Connection getConnection(){
        return this.connection;
    }


}
