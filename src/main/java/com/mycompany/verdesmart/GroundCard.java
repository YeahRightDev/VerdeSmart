package com.mycompany.verdesmart;
/**
 * Custom Swing component representing a visual card for a garden block (Ground).
 * Displays information such as name, area, and crop type along with interaction buttons.
 */
public class GroundCard extends javax.swing.JPanel {
    // Unique database primary key identifier representing this specific garden record
    
    private int id_Garden;
    private int iduser;
    // ONLY SAFE CONSTRUCTOR: Forces the reception of the real database ID
    public GroundCard(int idGarden, String name, String area, String plant, int idUser) {
        initComponents();
        this.id_Garden = idGarden; 
        jLabel1.setText(name);
        jLabel2.setText("AREA: " + area + " m²");
        jLabel3.setText(plant);
        this.iduser = idUser;
        formatDesign();
    }

   private void formatDesign() {
    // 1. Remove background rendering from the outer container
    this.setOpaque(false); 
    
    // 2. Configure the core panel inner background with FlatLaf styling properties
    if (jPanel1 != null) {
        jPanel1.setOpaque(false); // Let FlatLaf paint the background bounds instead of standard Swing
        jPanel1.putClientProperty("FlatLaf.style", "arc: 30; background: #FFFFFF;");
    }

    // Button formatting styles (keeps your UI looking clean)
    jButton1.setPreferredSize(new java.awt.Dimension(42, 42));
    jButton1.setSize(42, 42);
    jButton1.putClientProperty("FlatLaf.style", "background:#80C1DF; arc:999; borderWidth:0; focusWidth:0;");
    jButton1.setContentAreaFilled(false);
    jButton1.setBorderPainted(false);
    jButton1.setFocusPainted(false);

    jButton3.setPreferredSize(new java.awt.Dimension(42, 42));
    jButton3.setSize(42, 42);
    jButton3.putClientProperty("FlatLaf.style", "background:#EF9FBC; arc:999; borderWidth:0; focusWidth:0;");
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
        
        if (parentWindow instanceof MONITORING) {
           // This block executes if you are deleting from the Monitoring screen
            MONITORING monitoreoActual = (MONITORING) parentWindow;
            
           // Note: If you changed the 'delete' constructor to receive 'grounds',
            // ideally monitoreoActual should have a reference to grounds or pass null if it is another logic.
            // For now, to avoid compilation errors if 'delete' strictly requests grounds:
            delete del = new delete(null, this.id_Garden,iduser);
            del.setVisible(true);
            monitoreoActual.setVisible(false);
            
        } else if (parentWindow instanceof grounds) {
            // THIS IS THE BLOCK THAT EXECUTES ON YOUR GARDENS PAGE!
            grounds home_page = (grounds) parentWindow;
            
          //We pass 'home_page' (the actual instance of grounds) to the delete window
            delete del = new delete(home_page, this.id_Garden,iduser); 
            del.setVisible(true);
            
            //You can temporarily hide the main screen while confirming
            home_page.setVisible(false); 
            
        } else {
            // Fallback case in case none of the above are found
            delete del = new delete(null, this.id_Garden,iduser);
            del.setVisible(true);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        java.awt.Window parentWindow = javax.swing.SwingUtilities.getWindowAncestor(this);

        if (parentWindow instanceof grounds) {
            grounds mainScreen = (grounds) parentWindow;
            String currentGroundName = jLabel1.getText();

            // MONITORING will now correctly receive the active instance and the name
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
        //Activate anti-aliasing for better rounded rendering
        java.awt.Graphics2D g2 = (java.awt.Graphics2D) g.create();
        g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(java.awt.Color.WHITE); 
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
        g2.dispose();
        super.paintComponent(g);
    }
}
