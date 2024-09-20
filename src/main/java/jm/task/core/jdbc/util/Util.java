package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/pp_1_1_3_jdbc_hibernate_new";
    private static final String USER_NAME = "User_DB1";
    private static final String PASSWORD = "Jav123@!@123";

    private static Connection connection = null;

    public Util() {
    }

    public static Connection getConnection() {

        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

        } catch (SQLException e) {
            System.out.println("Не удалось загрузить класс драйвера!");
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (!connection.isClosed()) {
            connection.close();
        }
    }
}
