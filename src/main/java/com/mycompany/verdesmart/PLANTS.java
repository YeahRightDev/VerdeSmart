package com.mycompany.verdesmart;

    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import org.netbeans.lib.awtextra.*;

 public class PLANTS extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PLANTS.class.getName());
    
    private grounds groundsScreen;
    private String groundName;
    private String groundArea;
    private String selectedPlant = "No plant selected";

    
    public PLANTS(grounds groundsScreen, String groundName, String groundArea) {
        this.groundsScreen = groundsScreen;
        this.groundName = groundName;
        this.groundArea = groundArea;

        initComponents();
        this.setSize(800,700);
        
        jButton1.setContentAreaFilled(false); 
        jButton1.setBorderPainted(false);     
        jButton1.setFocusPainted(false);  
        
        jButton2.setContentAreaFilled(false); 
        jButton2.setBorderPainted(false);     
        jButton2.setFocusPainted(false);  
        
        jButton3.setContentAreaFilled(false); 
        jButton3.setBorderPainted(false);     
        jButton3.setFocusPainted(false);  
        
         jButton4.putClientProperty("FlatLaf.style",
        "background:#1B5E20;" +
        "foreground:#FFFFFF;" +
        "borderWidth:0;" +
        "focusWidth:0;" +
        "arc:999;");
         
       btnSave.setPreferredSize(new java.awt.Dimension(40, 40));
       btnSave.setSize(42, 42);
       btnSave.putClientProperty("FlatLaf.style", "background: #1B4D2F; arc: 999; borderWidth: 0; focusWidth: 0;");
        
        jPanel3.putClientProperty("FlatLaf.style", "arc: 30;");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnDiffenbachia = new javax.swing.JButton();
        btnArbolAbundancia = new javax.swing.JButton();
        btnCoronaCristo = new javax.swing.JButton();
        btnDurantia = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(199, 221, 181));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(27, 77, 47));

        jButton1.addActionListener(this::jButton1ActionPerformed);

        jLabel1.setFont(new java.awt.Font("Sylfaen", 0, 36)); // NOI18N
        jLabel1.setText("Verde Smart");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(54, 54, 54)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(331, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton2)
                        .addComponent(jButton1)))
                .addGap(8, 8, 8))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, -1));

        jButton3.addActionListener(this::jButton3ActionPerformed);
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(27, 77, 47));
        jLabel3.setText("-----------------------------------------");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 250, 40));
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, -1, -1));

        btnDiffenbachia.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        btnDiffenbachia.setText(" Diffenbachia                                                                                                  ");
        btnDiffenbachia.addActionListener(this::btnDiffenbachiaActionPerformed);

        btnArbolAbundancia.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        btnArbolAbundancia.setText("Arbol abundancia                                                                                ");
        btnArbolAbundancia.setToolTipText("");
        btnArbolAbundancia.addActionListener(this::btnArbolAbundanciaActionPerformed);

        btnCoronaCristo.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        btnCoronaCristo.setText("Corona de Cristo                                                                                ");
        btnCoronaCristo.addActionListener(this::btnCoronaCristoActionPerformed);

        btnDurantia.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        btnDurantia.setText("Durantia                                                                                                         ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnArbolAbundancia)
                    .addComponent(btnDiffenbachia)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btnCoronaCristo, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnDurantia))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnCoronaCristo)
                .addGap(49, 49, 49)
                .addComponent(btnDiffenbachia)
                .addGap(36, 36, 36)
                .addComponent(btnArbolAbundancia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(btnDurantia)
                .addGap(33, 33, 33))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 181, 710, 390));

        jLabel4.setFont(new java.awt.Font("Sylfaen", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(27, 77, 47));
        jLabel4.setText("Plantas");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, -1, -1));

        btnSave.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        btnSave.setText("Guardar");
        btnSave.addActionListener(this::btnSaveActionPerformed);
        jPanel1.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 600, 190, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 804, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnArbolAbundanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArbolAbundanciaActionPerformed
        // TODO add your handling code here:
        selectedPlant = "Arbol abundancia";
    }//GEN-LAST:event_btnArbolAbundanciaActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        if (selectedPlant == null || selectedPlant.equals("No plant selected")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select a plant first.");
            return;
        }

        if (groundsScreen != null) {

            card newCard = new card(
                    groundName,
                    groundArea,
                    selectedPlant
            );

            newCard.setMaximumSize(new java.awt.Dimension(650, 150));
            newCard.setPreferredSize(new java.awt.Dimension(650, 150));
            newCard.setMinimumSize(new java.awt.Dimension(650, 150));
            newCard.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);

            groundsScreen.getJPanel3().add(newCard);
            groundsScreen.getJPanel3().add(javax.swing.Box.createVerticalStrut(10));

            groundsScreen.getJPanel3().revalidate();
            groundsScreen.getJPanel3().repaint();

            groundsScreen.setVisible(true);
        }

        // Cerrar la ventana actual
        dispose();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ADD1 addWindow = new ADD1(groundsScreen);
        addWindow.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ADD1 addWindow = new ADD1(groundsScreen);
        addWindow.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnCoronaCristoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCoronaCristoActionPerformed
        // TODO add your handling code here:
        selectedPlant = "Corona de Cristo";
    }//GEN-LAST:event_btnCoronaCristoActionPerformed

    private void btnDiffenbachiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiffenbachiaActionPerformed
        // TODO add your handling code here:
        selectedPlant = "Diffenbachia";
    }//GEN-LAST:event_btnDiffenbachiaActionPerformed

    class RoundedPanel extends javax.swing.JPanel {
    private int cornerRadius;
    public RoundedPanel(int cornerRadius) {
        this.cornerRadius = cornerRadius;
        setOpaque(false);
    }
    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);

        java.awt.Graphics2D g2d = (java.awt.Graphics2D) g;
        g2d.setRenderingHint(
                java.awt.RenderingHints.KEY_ANTIALIASING,
                java.awt.RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(getBackground());
        g2d.fillRoundRect(
                0,
                0,
                getWidth() - 1,
                getHeight() - 1,
                cornerRadius,
                cornerRadius
        );
    }

}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArbolAbundancia;
    private javax.swing.JButton btnCoronaCristo;
    private javax.swing.JButton btnDiffenbachia;
    private javax.swing.JButton btnDurantia;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
