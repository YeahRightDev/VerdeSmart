package com.mycompany.verdesmart;

public class VerdeSmart {
    public static void main(String[] args) {
        try {
            System.out.println("Intentando conectar al servidor de MySQL...");
            
            java.sql.Connection cn = ConexionBaseDatos.getInstancia().getConexion();
            
            if (cn != null && !cn.isClosed()) {
                System.out.println("ola, ya esta conectado con el usuario: sopes");
                System.out.println("La base de datos verde_smart esta lista");
                
                java.awt.EventQueue.invokeLater(() -> {
                    login2 ventanaLogin = new login2(); 
                    ventanaLogin.setVisible(true);
                });
            }
        } catch (Exception e) {
            System.out.println("\n error al conectar ");
            System.out.println("Causa del fallo: " + e.getMessage());
            System.out.println("HOla");
        }
        LOGIN LOG = new LOGIN();
        LOG.setVisible(true);
      
    }
}