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
        //
        jLabel2.setText("AREA: " + area + " ");
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
    btnmonitoring.setPreferredSize(new java.awt.Dimension(42, 42));
    btnmonitoring.setSize(42, 42);
    btnmonitoring.putClientProperty("FlatLaf.style", "background:#80C1DF; arc:999; borderWidth:0; focusWidth:0;");
    btnmonitoring.setContentAreaFilled(false);
    btnmonitoring.setBorderPainted(false);
    btnmonitoring.setFocusPainted(false);

    btndelete.setPreferredSize(new java.awt.Dimension(42, 42));
    btndelete.setSize(42, 42);
    btndelete.putClientProperty("FlatLaf.style", "background:#EF9FBC; arc:999; borderWidth:0; focusWidth:0;");
    btndelete.setContentAreaFilled(false);
    btndelete.setBorderPainted(false);
    btndelete.setFocusPainted(false);

    jPanel1.setComponentZOrder(btnmonitoring, 0);
    jPanel1.setComponentZOrder(btndelete, 0);
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnmonitoring = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Sylfaen", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(27, 77, 47));
        jLabel1.setText("Nombre del Jardín");

        jLabel2.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(27, 77, 47));
        jLabel2.setText("Área ");

        jLabel3.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(27, 77, 47));
        jLabel3.setText("Planta ");

        btnmonitoring.setIcon(new javax.swing.ImageIcon("C:\\Users\\Brith\\Documents\\GitHub\\VerdeSmart\\src\\main\\resources\\imagenes\\gota-de-agua (1).png")); // NOI18N
        btnmonitoring.addActionListener(this::btnmonitoringActionPerformed);

        btndelete.setIcon(new javax.swing.ImageIcon("C:\\Users\\Brith\\Documents\\GitHub\\VerdeSmart\\src\\main\\resources\\imagenes\\eliminar (1).png")); // NOI18N
        btndelete.addActionListener(this::btndeleteActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btndelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnmonitoring, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(btnmonitoring, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btndelete, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                        .addGap(16, 16, 16))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
     
        java.awt.Window parentWindow = javax.swing.SwingUtilities.getWindowAncestor(this);
        
        if (parentWindow instanceof MONITORING) {
           // This block executes if you are deleting from the Monitoring screen
            MONITORING current_monitoring = (MONITORING) parentWindow;
            
           // Note: If you changed the 'delete' constructor to receive 'grounds',
            // ideally monitoreoActual should have a reference to grounds or pass null if it is another logic.
            // For now, to avoid compilation errors if 'delete' strictly requests grounds:
            delete del = new delete(null, this.id_Garden,iduser);
            del.setVisible(true);
            current_monitoring.setVisible(false);
            
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
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnmonitoringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmonitoringActionPerformed
        java.awt.Window parentWindow = javax.swing.SwingUtilities.getWindowAncestor(this);

        if (parentWindow instanceof grounds) {
            grounds mainScreen = (grounds) parentWindow;
            String currentGroundName = jLabel1.getText();

            // MONITORING will now correctly receive the active instance and the name
            MONITORING monitoringWindow = new MONITORING(mainScreen, currentGroundName);
            monitoringWindow.setVisible(true);
            mainScreen.setVisible(false);
        } else {
            System.out.println("Error: No se encontró la ventana principal 'grounds'.");
        }
    }//GEN-LAST:event_btnmonitoringActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnmonitoring;
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
