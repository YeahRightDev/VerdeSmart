package com.mycompany.verdesmart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    private static ConexionBaseDatos instancia;
    private Connection conexion;
    
    private String url = "jdbc:mysql://localhost:3306/verde_smart";
    private String usuario = "sopes"; 
    private String contrasena = "Sopes.2026*"; 
    private ConexionBaseDatos() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conexion = DriverManager.getConnection(url, usuario, contrasena);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Error: No se encontró el Driver de MySQL: " + e.getMessage());
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public static ConexionBaseDatos getInstancia() throws SQLException {
        if (instancia == null) {
            instancia = new ConexionBaseDatos();
            System.out.println("Conexión establecida por primera vez (Singleton).");
        } else if (instancia.getConexion().isClosed()) {
            instancia = new ConexionBaseDatos();
            System.out.println("Conexión reabierta");
        }
        return instancia;
    }
}