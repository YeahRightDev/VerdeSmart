package com.mycompany.verdesmart;

public class GroundCard extends javax.swing.JPanel {

    public GroundCard() {
        initComponents();
        formatDesign();
    }

    public GroundCard(String groundName, String groundArea, String plantName) {
        initComponents();

        jLabel1.setText(groundName);
        jLabel2.setText("AREA: " + groundArea + " m²");
        jLabel3.setText(plantName);

        formatDesign();
    }   

    private void formatDesign() {

        if (jPanel1 != null) {
            jPanel1.setOpaque(false);
            jPanel1.setEnabled(false);
        }

        jButton1.setPreferredSize(new java.awt.Dimension(42, 42));
        jButton1.setSize(42, 42);
        jButton1.putClientProperty("FlatLaf.style",
                "background:#80C1DF; arc:999; borderWidth:0; focusWidth:0;");
        jButton1.setContentAreaFilled(false);
        jButton1.setBorderPainted(false);
        jButton1.setFocusPainted(false);

        jButton3.setPreferredSize(new java.awt.Dimension(42, 42));
        jButton3.setSize(42, 42);
        jButton3.putClientProperty("FlatLaf.style",
                "background:#EF9FBC; arc:999; borderWidth:0; focusWidth:0;");
        jButton3.setContentAreaFilled(false);
        jButton3.setBorderPainted(false);
        jButton3.setFocusPainted(false);

        jPanel1.setComponentZOrder(jButton1, 0);
        jPanel1.setComponentZOrder(jButton3, 0);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(27, 77, 47));
        jLabel1.setText("Nombre Jardin");

        jLabel2.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(27, 77, 47));
        jLabel2.setText("Area ");

        jLabel3.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(27, 77, 47));
        jLabel3.setText("Planta ");

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Brith\\Documents\\GitHub\\VerdeSmart\\src\\main\\resources\\imagenes\\gota-de-agua (1).png")); // NOI18N
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Brith\\Documents\\GitHub\\VerdeSmart\\src\\main\\resources\\imagenes\\eliminar (1).png")); // NOI18N
        jButton3.addActionListener(this::jButton3ActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        java.awt.Window parentWindow = javax.swing.SwingUtilities.getWindowAncestor(this);

        if (!(parentWindow instanceof MONITORING)) {
            
            delete deleteWindow = new delete(null);
            deleteWindow.setVisible(true);
        } else {
            
            MONITORING monitoringWindow = (MONITORING) parentWindow;

            delete deleteWindow = new delete(monitoringWindow);
            deleteWindow.setVisible(true);

            monitoringWindow.setVisible(false);

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Find the parent window dynamically
        java.awt.Window parentWindow = javax.swing.SwingUtilities.getWindowAncestor(this);

        if (parentWindow instanceof grounds) {

            grounds mainScreen = (grounds) parentWindow;

            String currentGroundName = jLabel1.getText();

            MONITORING monitoringWindow = new MONITORING(mainScreen, currentGroundName);
            monitoringWindow.setVisible(true);

            mainScreen.setVisible(false);

        } else {

            System.out.println("Error: Main window 'grounds' was not found.");

        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);

        java.awt.Graphics2D g2 = (java.awt.Graphics2D) g.create();
        g2.setRenderingHint(
                java.awt.RenderingHints.KEY_ANTIALIASING,
                java.awt.RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(java.awt.Color.WHITE);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);

        g2.dispose();
    }
}
