package com.mycompany.verdesmart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;

    private final String URL = "jdbc:mysql://localhost:3306/verde_smart";
    private final String USER = "root";
    private final String PASSWORD = "1234";

    private DatabaseConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL Driver not found: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DatabaseConnection getInstance() throws SQLException {

        if (instance == null) {
            instance = new DatabaseConnection();
            System.out.println("Database connection established.");
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
            System.out.println("Database connection reopened.");
        }

        return instance;
    }
}