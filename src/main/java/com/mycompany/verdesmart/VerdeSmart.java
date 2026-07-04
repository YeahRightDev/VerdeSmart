package com.mycompany.verdesmart;

import java.sql.Connection;
import java.sql.SQLException;

public class VerdeSmart {

    public static void main(String[] args) {

        try {
            System.out.println("Connecting to MySQL server...");

            Connection connection = DatabaseConnection.getInstance().getConnection();

            if (connection != null && !connection.isClosed()) {
                System.out.println("Connection established successfully.");
                System.out.println("Database 'verde_smart' is ready.");
            }

        } catch (SQLException e) {

            System.out.println("\nConnection failed.");
            System.out.println("Error: " + e.getMessage());
        }

        LOGIN loginWindow = new LOGIN();
        loginWindow.setVisible(true);
    }
}