package com.highradius.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/h2h_intern"; 
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "C_20051685";

    // Establishing database connection
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
