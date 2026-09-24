package org.com.jdbc_integration.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {


    public static Connection getConnection() throws SQLException {

        String URL = "jdbc:mysql://localhost:3306/weintern_project";
        String USER = "root";
        String PASSWORD = "admin";

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
