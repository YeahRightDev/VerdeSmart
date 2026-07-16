package com.mycompany.verdesmart;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
/**
 * MONITORING Frame class.
 * Displays real-time or historical soil status, humidity records, and 
 * irrigation tracking parameters linked to a selected garden dashboard.
 */
public class MONITORING extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MONITORING.class.getName());

    private grounds mainScreen; // Reference holder to maintain the active main screen instance


    public MONITORING(grounds mainScreen, String currentGroundName) {
        initComponents();
        this.mainScreen = mainScreen;
        
        // 1. Apply core UI styling elements first
        styleLabels();
        
        // 2. Update view headers and query active metrics if a target garden reference is provided
        if (currentGroundName != null && !currentGroundName.isEmpty()) {
            jLabel1.setText(currentGroundName.toUpperCase());
            consultarDatosMonitoreo(currentGroundName);
        }
    }
    
    private void consultarDatosMonitoreo(String nombreJardin) {
    // Database query targeting the latest available monitoring history metric for this specific plot
    String sqlMonitoreo = "SELECT m.Humidity FROM monitoring m "
                        + "JOIN garden g ON m.id_Garden = g.id_Garden "
                        + "WHERE g.Name = ? "
                        + "ORDER BY m.Date_Time DESC LIMIT 1";

  // Database query targeting the latest logged irrigation entry for scheduling updates
    String sqlRiego = "SELECT i.Date_time FROM irrigation i "
                    + "JOIN garden g ON i.id_Garden = g.id_Garden "
                    + "WHERE g.Name = ? "
                    + "ORDER BY i.Date_time DESC LIMIT 1";

    try (java.sql.Connection con = DatabaseConnection.getInstance().getConnection()) {
        
        // 1. EXTRACT RECENT HUMIDITY PERCENTAGES
        try (java.sql.PreparedStatement psM = con.prepareStatement(sqlMonitoreo)) {
            psM.setString(1, nombreJardin);
            try (java.sql.ResultSet rsM = psM.executeQuery()) {
                if (rsM.next()) {
                    float humedad = rsM.getFloat("Humedad");
                    jLabel4.setText(String.format("%.1f%%", humedad));
                } else {
                    jLabel4.setText("N/D"); // Not Available
                }
            }
        }

        // 2. EXTRACT PREVIOUS IRRIGATION RUN (DATE AND TIME PROPERTIES)
        try (java.sql.PreparedStatement psR = con.prepareStatement(sqlRiego)) {
            psR.setString(1, nombreJardin);
            try (java.sql.ResultSet rsR = psR.executeQuery()) {
                if (rsR.next()) {
                    java.sql.Timestamp ts = rsR.getTimestamp("Fecha y hora");
                    
                    // Specific date and time mask pattern formattings for split visualizations
                    java.text.SimpleDateFormat sdfFecha = new java.text.SimpleDateFormat("dd/MM/yyyy");
                    java.text.SimpleDateFormat sdfHora = new java.text.SimpleDateFormat("hh:mm a");
                    
                    lblFechaRiego.setText(sdfFecha.format(ts));
                    lblHoraRiego.setText(sdfHora.format(ts));
                } else {
                    lblFechaRiego.setText("Sin registros");
                    lblHoraRiego.setText("Sin registros");
                }
            }
        }

    } catch (java.sql.SQLException ex) {
        logger.log(java.util.logging.Level.SEVERE, "Error al cargar datos de monitoreo", ex);
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Error al conectar con la base de datos: " + ex.getMessage(), 
            "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
}
    private void styleLabels() {
        jLabel4.setOpaque(true);
        lblFechaRiego.setOpaque(true);
        lblHoraRiego.setOpaque(true);

        jButton2.setContentAreaFilled(false);
        jButton2.setBorderPainted(false);
        jButton2.setFocusPainted(false);

        jLabel4.setBackground(new Color(199,221,181));
        jLabel4.setForeground(new Color(27,77,47));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("45%");

        lblFechaRiego.setBackground(new Color(240,240,240));
        lblFechaRiego.setForeground(new Color(27,77,47));
        lblFechaRiego.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFechaRiego.setText("30/06/2026");

        lblHoraRiego.setBackground(new Color(240,240,240));
        lblHoraRiego.setForeground(new Color(27,77,47));
        lblHoraRiego.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHoraRiego.setText("10:50 PM");

        javax.swing.border.AbstractBorder roundedBorder =
                new javax.swing.border.AbstractBorder() {
            @Override
            public void paintBorder(java.awt.Component c, Graphics g,
                                    int x, int y, int width, int height) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(
                        RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(27,77,47));
                g2.setStroke(new java.awt.BasicStroke(2));
                g2.drawRoundRect(x + 1, y + 1, width - 3, height - 3, 20, 20);
                g2.dispose();
            }
        };

        jLabel4.setBorder(roundedBorder);
        lblFechaRiego.setBorder(roundedBorder);
        lblHoraRiego.setBorder(roundedBorder);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblUltimoRiegoTitulo = new javax.swing.JLabel();
        lblFechaRiego = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblHoraRiego = new javax.swing.JLabel();
        lblUltimoRiego = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(199, 221, 181));

        jPanel2.setBackground(new java.awt.Color(27, 77, 47));

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Brith\\Documents\\GitHub\\VerdeSmart\\src\\main\\resources\\imagenes\\boton-x.png")); // NOI18N
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jLabel1.setFont(new java.awt.Font("Sylfaen", 0, 36)); // NOI18N
        jLabel1.setText("MONITOREO");

        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Brith\\Documents\\GitHub\\VerdeSmart\\src\\main\\resources\\imagenes\\hojas-de-coca (1).png")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(27, 77, 47));
        jLabel2.setText("ESTADO DEL SUELO");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(27, 77, 47));
        jLabel3.setText("HUMEDAD");

        jLabel4.setBackground(new java.awt.Color(199, 221, 181));

        lblUltimoRiegoTitulo.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        lblUltimoRiegoTitulo.setForeground(new java.awt.Color(27, 77, 47));
        lblUltimoRiegoTitulo.setText("ULTIMO RIEGO");

        jLabel7.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(27, 77, 47));
        jLabel7.setText("FECHA ");

        jLabel8.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(27, 77, 47));
        jLabel8.setText("HORA");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(lblFechaRiego, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
                    .addComponent(lblUltimoRiegoTitulo)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblHoraRiego, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblUltimoRiego, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblUltimoRiegoTitulo)
                .addGap(18, 18, 18)
                .addComponent(lblUltimoRiego, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(lblFechaRiego, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(60, 60, 60)
                .addComponent(lblHoraRiego, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       // Uses the existing window object instance instead of creating a blank 'new grounds()' screen
        if (this.mainScreen != null) {
            this.mainScreen.setVisible(true);
        } else {
            new grounds().setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblFechaRiego;
    private javax.swing.JLabel lblHoraRiego;
    private javax.swing.JLabel lblUltimoRiego;
    private javax.swing.JLabel lblUltimoRiegoTitulo;
    // End of variables declaration//GEN-END:variables
}
