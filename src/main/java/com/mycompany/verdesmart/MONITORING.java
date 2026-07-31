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
        
        this.getRootPane().setDefaultButton(btnclose);
        this.mainScreen = mainScreen;
        jPanel3.putClientProperty("FlatLaf.style", "arc: 30;");
        // 1. Apply core UI styling elements first
        styleLabels();
        
        // 2. Update view headers and query active metrics if a target garden reference is provided
        if (currentGroundName != null && !currentGroundName.isEmpty()) {
            jLabel1.setText(currentGroundName.toUpperCase());
            queryMonitoringData(currentGroundName);
        }
        btnclose.setContentAreaFilled(false); 
        btnclose.setBorderPainted(false);     
        btnclose.setFocusPainted(false);  
        
        btnback.setContentAreaFilled(false); 
        btnback.setBorderPainted(false);     
        btnback.setFocusPainted(false);  
    }
    
    private void queryMonitoringData(String namegarden) {
        // Clear all labels first (removes background colors, borders, and text)
        resetPlantLabels();

        String sqlPlants = "SELECT p.Plant_Name, p.how_often_to_water, gp.Sown_Date "
                         + "FROM plant p "
                         + "JOIN garden_plant gp ON p.id_Plant = gp.id_Plant "
                         + "JOIN garden g ON gp.id_Garden = g.id_Garden "
                         + "WHERE g.Garden_Name = ?";

        try (java.sql.Connection con = DatabaseConnection.getInstance().getConnection();
             java.sql.PreparedStatement psM = con.prepareStatement(sqlPlants)) {
            
            psM.setString(1, namegarden);
            
            try (java.sql.ResultSet rs = psM.executeQuery()) {
                int count = 0;
                java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy");

                // Iterate through the plants assigned to this garden
                while (rs.next()) {
                    count++;
                    String plantName = rs.getString("Plant_Name");
                    String wateringFrequency = rs.getString("how_often_to_water");
                    java.sql.Timestamp sownDate = rs.getTimestamp("Sown_Date");
                    
                    String dateStr = (sownDate != null) ? dateFormat.format(sownDate) : "No date";
                    String waterStr = (wateringFrequency != null) ? wateringFrequency : "Normal watering";

                    // Assign data and activate styles ONLY for existing database records
                    switch (count) {
                        case 1:
                            activateLabelStyle(lblCrownofThorns,  plantName + " (Sembrada: " + dateStr + ")");
                            activateLabelStyle(lblCrownofThorns2, "Cada: " + waterStr);
                            break;
                        case 2:
                            activateLabelStyle(lblDieffenbachia,plantName + " (Sembrada: " + dateStr + ")");
                            activateLabelStyle(lblDieffenbachia2, "Cada: " + waterStr);
                            break;
                        case 3:
                            activateLabelStyle(lblTreeofAbundance,  plantName + " (Sembrada: " + dateStr + ")");
                            activateLabelStyle(lblTreeofAbundance2, "Cada: " + waterStr);
                            break;
                        case 4:
                            activateLabelStyle(lbldurantia,  plantName + " (Sembrada: " + dateStr + ")");
                            activateLabelStyle(lbldurantia2, "Cada: " + waterStr);
                            break;
                    }
                }

                // If the garden has no registered plants
                if (count == 0) {
                    lblCrownofThorns.setText("This garden has no registered plants.");
                    lblCrownofThorns.setVisible(true);
                }
            }

        } catch (java.sql.SQLException ex) {
            logger.log(java.util.logging.Level.SEVERE, "Error loading garden plants", ex);
            javax.swing.JOptionPane.showMessageDialog(this,
                "Error retrieving garden plants: " + ex.getMessage(),
                "DB Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

   private void activateLabelStyle(javax.swing.JLabel label, String text) {
        if (label == null) return;

        javax.swing.border.AbstractBorder roundedBorder = new javax.swing.border.AbstractBorder() {
            @Override
            public void paintBorder(java.awt.Component c, Graphics g, int x, int y, int width, int height) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(27, 77, 47));
                g2.setStroke(new java.awt.BasicStroke(2));
                g2.drawRoundRect(x + 1, y + 1, width - 3, height - 3, 20, 20);
                g2.dispose();
            }
        };

        label.setText(text);
        label.setOpaque(true);
        label.setBackground(new Color(199, 221, 181));
        label.setForeground(new Color(27, 77, 47));
        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setBorder(roundedBorder);
        label.setVisible(true);
    }
// Helper method to clear or hide plant labels before loading new data
private void resetPlantLabels() {
    javax.swing.JLabel[] labels = {
            lblCrownofThorns, lblCrownofThorns2,
            lblDieffenbachia, lblDieffenbachia2,
            lblTreeofAbundance, lblTreeofAbundance2,
            lbldurantia, lbldurantia2
          
        };

        for (javax.swing.JLabel lbl : labels) {
        if (lbl != null) {
            lbl.setText(" ");
            lbl.setOpaque(false);
            lbl.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
            
            // Conserva la altura original que le diste en el JFrame de NetBeans
            if (lbl.getPreferredSize() != null && lbl.getPreferredSize().height > 0) {
                lbl.setPreferredSize(new java.awt.Dimension(lbl.getPreferredSize().width, lbl.getPreferredSize().height));
            }

            lbl.setVisible(true);
        }
    }
    }
    private void styleLabels() {
      btnback.setContentAreaFilled(false);
        btnback.setBorderPainted(false);
        btnback.setFocusPainted(false);

        // Hide all elements completely until data is loaded
        resetPlantLabels();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnclose = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnback = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblCrownofThorns = new javax.swing.JLabel();
        lblCrownofThorns2 = new javax.swing.JLabel();
        lblTreeofAbundance = new javax.swing.JLabel();
        lbldurantia = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblDieffenbachia = new javax.swing.JLabel();
        lblDieffenbachia2 = new javax.swing.JLabel();
        lblTreeofAbundance2 = new javax.swing.JLabel();
        lbldurantia2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(199, 221, 181));

        jPanel2.setBackground(new java.awt.Color(27, 77, 47));

        btnclose.setIcon(new javax.swing.ImageIcon("C:\\Users\\Brith\\Documents\\GitHub\\VerdeSmart\\src\\main\\resources\\imagenes\\boton-x.png")); // NOI18N
        btnclose.addActionListener(this::btncloseActionPerformed);

        jLabel1.setFont(new java.awt.Font("Sylfaen", 0, 36)); // NOI18N
        jLabel1.setText("Datos del riego de las plantas");

        btnback.setIcon(new javax.swing.ImageIcon("C:\\Users\\Brith\\Documents\\GitHub\\VerdeSmart\\src\\main\\resources\\imagenes\\hojas-de-coca (1).png")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnback)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnclose)
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnback, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnclose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Sylfaen", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(27, 77, 47));
        jLabel2.setText("Cuando regar");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(27, 77, 47));
        jLabel3.setText("Plantas");

        lblCrownofThorns.setBackground(new java.awt.Color(199, 221, 181));
        lblCrownofThorns.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        lblCrownofThorns.setForeground(new java.awt.Color(27, 77, 47));
        lblCrownofThorns.setText("Corona");

        lblCrownofThorns2.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        lblCrownofThorns2.setForeground(new java.awt.Color(27, 77, 47));
        lblCrownofThorns2.setText("corona");

        lblTreeofAbundance.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        lblTreeofAbundance.setForeground(new java.awt.Color(27, 77, 47));
        lblTreeofAbundance.setText("Arbol");

        lbldurantia.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        lbldurantia.setForeground(new java.awt.Color(27, 77, 47));
        lbldurantia.setText("Durantia");

        jLabel8.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(27, 77, 47));
        jLabel8.setText("Próximo riego");

        lblDieffenbachia.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        lblDieffenbachia.setForeground(new java.awt.Color(27, 77, 47));
        lblDieffenbachia.setText("DIfenbacha");

        lblDieffenbachia2.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        lblDieffenbachia2.setForeground(new java.awt.Color(27, 77, 47));
        lblDieffenbachia2.setText("difen");

        lblTreeofAbundance2.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        lblTreeofAbundance2.setForeground(new java.awt.Color(27, 77, 47));
        lblTreeofAbundance2.setText("arbol");

        lbldurantia2.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        lbldurantia2.setForeground(new java.awt.Color(27, 77, 47));
        lbldurantia2.setText("dur");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTreeofAbundance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCrownofThorns, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDieffenbachia, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
                    .addComponent(lbldurantia2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTreeofAbundance2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8)
                            .addComponent(jLabel3)
                            .addComponent(lblCrownofThorns2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDieffenbachia2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbldurantia, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(48, 48, 48))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCrownofThorns, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDieffenbachia, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTreeofAbundance, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbldurantia, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCrownofThorns2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDieffenbachia2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTreeofAbundance2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbldurantia2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
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
                .addContainerGap(26, Short.MAX_VALUE))
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

    private void btncloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncloseActionPerformed
       // Uses the existing window object instance instead of creating a blank 'new grounds()' screen
        if (this.mainScreen != null) {
            this.mainScreen.setVisible(true);
        } else {
            new grounds(0).setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_btncloseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnback;
    private javax.swing.JButton btnclose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblCrownofThorns;
    private javax.swing.JLabel lblCrownofThorns2;
    private javax.swing.JLabel lblDieffenbachia;
    private javax.swing.JLabel lblDieffenbachia2;
    private javax.swing.JLabel lblTreeofAbundance;
    private javax.swing.JLabel lblTreeofAbundance2;
    private javax.swing.JLabel lbldurantia;
    private javax.swing.JLabel lbldurantia2;
    // End of variables declaration//GEN-END:variables
}
