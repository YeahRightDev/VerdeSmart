package com.mycompany.verdesmart;

import com.formdev.flatlaf.FlatLightLaf;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * VerdeSmart Class.
 * This serves as the primary entry point for the application. It initializes the
 * UI Look and Feel, verifies database connectivity, and launches the initial login window.
 */
public class VerdeSmart {

    public static void main(String[] args) {
        FlatLightLaf.setup();
    // --- Look and Feel Initialization ---
        try {
            com.formdev.flatlaf.FlatLightLaf.setup(); // Usa FlatDarkLaf.setup(); si prefieres tema oscuro
        } catch (Exception ex) {
            System.err.println("No se pudo inicializar el Look and Feel de FlatLaf: " + ex.getMessage());
        }
        // ----------------------------------

        // --- Database Connection Verification Test ---
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
        
        // --- View Instantiation and Navigation Lifecycle ---
        LOGIN loginWindow = new LOGIN();
        loginWindow.setVisible(true);
    }
}