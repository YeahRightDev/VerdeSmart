package com.mycompany.verdesmart;
public class grounds extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(grounds.class.getName());
    /**
     * Creates a new instance form of grounds.
     * Configures dimensions, custom FlatLaf style properties, backgrounds, 
     * transparent button structures, hidden scrollbar states, and triggers the database fetch.
     */
    public grounds() {
      initComponents();
        this.setSize(800,705);
       
        // Define dimension parameters for the Add Garden icon button component layer
        jButton3.setPreferredSize(new java.awt.Dimension(55, 55));
        jButton3.setSize(55, 55);

        // Apply advanced FlatLaf-specific geometric properties for custom arcs
        jButton3.putClientProperty("JButton.buttonType", "roundRect");
        jButton3.putClientProperty("JComponent.customArc", 100);

       // Inject FlatLaf-compliant global dark green styling properties directly
        jButton3.putClientProperty("FlatLaf.style",
        "background:#1B5E20;" +
        "foreground:#FFFFFF;" +
         "borderWidth:0;" +
        "focusWidth:0;" +
        "arc:999;");
            
        // Configure transparent interaction behaviors across the structural navigation buttons
        jButton1.setContentAreaFilled(false); 
        jButton1.setBorderPainted(false);     
        jButton1.setFocusPainted(false);  
        
        jButton2.setContentAreaFilled(false); 
        jButton2.setBorderPainted(false);     
        jButton2.setFocusPainted(false);  
        
        jButton3.setContentAreaFilled(false); 
        jButton3.setBorderPainted(false);     
        jButton3.setFocusPainted(false);  
        
       // Define baseline theme color constant (Soft Olive/Green)
        java.awt.Color miColorVerde = new java.awt.Color(0xC7DDB5);

       // Strip default line borders away from the background viewport scroll pane elements
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder());

        
        jScrollPane1.setOpaque(true);
        jScrollPane1.setBackground(miColorVerde);

        jScrollPane1.getViewport().setOpaque(true);
        jScrollPane1.getViewport().setBackground(miColorVerde);

        
        jPanel3.setBackground(miColorVerde);
        jPanel3.setOpaque(true);

        
        jScrollPane1.getVerticalScrollBar().putClientProperty("JComponent.border", javax.swing.BorderFactory.createEmptyBorder());
        jScrollPane1.getVerticalScrollBar().setBackground(miColorVerde);
        jScrollPane1.getVerticalScrollBar().setPreferredSize(new java.awt.Dimension(0, 0));

        
        jPanel1.setBackground(miColorVerde);
        this.setBackground(miColorVerde);
       
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.Y_AXIS));
        cargarJardinesDesdeBD();
    }
    
    
    
    /**
     * Queries records from the relational schema database table structure, 
     * generating individualized GroundCard display panels safely positioned 
     * with alignment parameters and spacer components.
     */
    public void cargarJardinesDesdeBD() {
        jPanel3.removeAll();
        
        String sql = "SELECT * FROM garden"; 

        try (java.sql.Connection con = DatabaseConnection.getInstance().getConnection();
             java.sql.PreparedStatement ps = con.prepareStatement(sql);
             java.sql.ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                // Map out columns directly following table indexing patterns
                int id = rs.getInt(1);          
                String nombre = rs.getString(2); 
                String metros = rs.getString(3); 
                String planta = rs.getString(4); 

                // Instantiate customized item row item component
                GroundCard tarjetaJardin = new GroundCard(id, nombre, metros, planta);

                // Force layout manager alignment context definitions to ensure clean centering alignment
                tarjetaJardin.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
                jPanel3.add(tarjetaJardin);
                // Add a structural tracking blank layout divider box of exactly 10 horizontal pixels
                jPanel3.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(0, 10)));
            }

        } catch (java.sql.SQLException ex) {
            logger.log(java.util.logging.Level.SEVERE, "Error al cargar los jardines en la interfaz gráfica", ex);
            javax.swing.JOptionPane.showMessageDialog(this, "Error al cargar datos: " + ex.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }

        jPanel3.revalidate();
        jPanel3.repaint();
    }

    public javax.swing.JPanel getJPanel3() {
        return this.jPanel3;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(199, 221, 181));

        jPanel2.setBackground(new java.awt.Color(27, 77, 47));
        jPanel2.setForeground(new java.awt.Color(27, 77, 47));

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Brith\\Documents\\GitHub\\VerdeSmart\\src\\main\\resources\\imagenes\\atras.png")); // NOI18N
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Brith\\Documents\\GitHub\\VerdeSmart\\src\\main\\resources\\imagenes\\hojas-de-coca (1).png")); // NOI18N

        jLabel2.setFont(new java.awt.Font("Sylfaen", 0, 48)); // NOI18N
        jLabel2.setText("Verde Smart");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(28, 28, 28)
                .addComponent(jButton2)
                .addGap(61, 61, 61)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Brith\\Documents\\GitHub\\VerdeSmart\\src\\main\\resources\\imagenes\\agregar.png")); // NOI18N
        jButton3.addActionListener(this::jButton3ActionPerformed);

        jLabel3.setFont(new java.awt.Font("Sylfaen", 0, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(27, 77, 47));
        jLabel3.setText("Mis Jardines");

        jScrollPane1.setBackground(new java.awt.Color(199, 221, 181));

        jPanel3.setBackground(new java.awt.Color(199, 221, 181));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 749, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(jLabel3)
                        .addGap(181, 181, 181)
                        .addComponent(jButton3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(254, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       ADD1 add = new ADD1(this); 
        add.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        login2 log = new login2();
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
