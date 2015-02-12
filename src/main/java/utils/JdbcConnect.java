package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnect {
    private final static String USER = "zaxid";
    private final static String PSWD = "02580258";
    private final static String URL = "jdbc:postgresql:university";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PSWD);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }
}
