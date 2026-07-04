package com.mycompany.verdesmart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Singleton class to manage database connections.
 * Ensures only a single connection instance exists throughout the application lifecycle.
 */
public class DatabaseConnection {

    // The single, static instance of this class
    private static DatabaseConnection instance;
    // The actual live connection reference object
    private Connection connection;

    // Database access credentials and connection endpoints
    private final String URL = "jdbc:mysql://localhost:3306/verde_smart";
    private final String USER = "root";
    private final String PASSWORD = "1234";

    /**
     * Private constructor to prevent direct instantiation from external classes.
     * Loads the JDBC driver class dynamically and establishes the backend pipeline.
     */
    private DatabaseConnection() throws SQLException {
        try {
            // Explicitly load the MySQL Connector/J driver class into runtime memory
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Instantiate the connection bridge using the specified parameters
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            // Translate driver missing exception into a standard database query exception
            throw new SQLException("MySQL Driver not found: " + e.getMessage());
        }
    }

    /**
     * Returns the raw active SQL Connection handler instance.
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Public access point to retrieve the globally shared instance.
     * Validates connection status and safely reinstantiates it if dead or uninitialized.
     */
    public static DatabaseConnection getInstance() throws SQLException {

        // Check if the Singleton context instance hasn't been created yet
        if (instance == null) {
            instance = new DatabaseConnection();
            System.out.println("Database connection established.");
        // If it exists but the channel was closed unexpectedly, rebuild the bridge
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
            System.out.println("Database connection reopened.");
        }

        return instance;
    }
}