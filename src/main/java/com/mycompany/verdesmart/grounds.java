package com.mycompany.verdesmart;
public class grounds extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(grounds.class.getName());
    /**
     * Creates a new instance form of grounds.
     * Configures dimensions, custom FlatLaf style properties, backgrounds, 
     * transparent button structures, hidden scrollbar states, and triggers the database fetch.
     */
     private int iduser;
    public grounds(int idUser) {
        
       this.iduser = idUser;
        
        initComponents();
        this.setSize(800,705);
       
        // Define dimension parameters for the Add Garden icon button component layer
        btnAdd.setPreferredSize(new java.awt.Dimension(55, 55));
        btnAdd.setSize(55, 55);

        // Apply advanced FlatLaf-specific geometric properties for custom arcs
        btnAdd.putClientProperty("JButton.buttonType", "roundRect");
        btnAdd.putClientProperty("JComponent.customArc", 100);

       // Inject FlatLaf-compliant global dark green styling properties directly
        btnAdd.putClientProperty("FlatLaf.style",
        "background:#1B5E20;" +
        "foreground:#FFFFFF;" +
         "borderWidth:0;" +
        "focusWidth:0;" +
        "arc:999;");
            
        // Configure transparent interaction behaviors across the structural navigation buttons
        btnback.setContentAreaFilled(false); 
        btnback.setBorderPainted(false);     
        btnback.setFocusPainted(false);  
        
        jButton2.setContentAreaFilled(false); 
        jButton2.setBorderPainted(false);     
        jButton2.setFocusPainted(false);  
        
        btnAdd.setContentAreaFilled(false); 
        btnAdd.setBorderPainted(false);     
        btnAdd.setFocusPainted(false);  
        
        btnmenu.setContentAreaFilled(false); 
        btnmenu.setBorderPainted(false);     
        btnmenu.setFocusPainted(false);  
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
        
        if (this.iduser <= 0) {
            jPanel3.revalidate();
            jPanel3.repaint();
            return;
        }
        String sql = "SELECT id_Garden, Garden_Name, Total_Area, Shape FROM garden WHERE id_User = ?";

       try (java.sql.Connection con = DatabaseConnection.getInstance().getConnection();
             java.sql.PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, this.iduser);
            
            try (java.sql.ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    // Map out columns directly following table indexing patterns
                    int id = rs.getInt(1);          
                    String nombre = rs.getString(2); 
                    String metros = rs.getString(3); 
                    String planta = rs.getString(4);
                     
                // Instantiate customized item row item component
                GroundCard tarjetaJardin = new GroundCard(id, nombre, metros, planta, this.iduser);

                // Force layout manager alignment context definitions to ensure clean centering alignment
                java.awt.Dimension tamanoFijo = new java.awt.Dimension(650, 150);
                    tarjetaJardin.setPreferredSize(tamanoFijo);
                    tarjetaJardin.setMinimumSize(tamanoFijo);
                    tarjetaJardin.setMaximumSize(tamanoFijo);
                    tarjetaJardin.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
                    
                javax.swing.JPanel contenedorTarjeta = new javax.swing.JPanel(new java.awt.BorderLayout());
                    contenedorTarjeta.setOpaque(false); // Para que mantenga el color verde de fondo
                    contenedorTarjeta.setPreferredSize(tamanoFijo);
                    contenedorTarjeta.setMinimumSize(tamanoFijo);
                    contenedorTarjeta.setMaximumSize(tamanoFijo);
                    contenedorTarjeta.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
                contenedorTarjeta.add(tarjetaJardin, java.awt.BorderLayout.CENTER);
                jPanel3.add(contenedorTarjeta);
                jPanel3.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(0, 10)));
            }
          }
        } catch (java.sql.SQLException ex) {
            logger.log(java.util.logging.Level.SEVERE, "Error al cargar los jardines en la interfaz gráfica", ex);
            javax.swing.JOptionPane.showMessageDialog(this, "Error al cargar datos: " + ex.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }

        jPanel3.revalidate();
        jPanel3.repaint();
        String sqlUsuario ="SELECT User_name, e_mail FROM users WHERE id_User = ?";
        try (java.sql.Connection con = DatabaseConnection.getInstance().getConnection();
             java.sql.PreparedStatement ps = con.prepareStatement(sqlUsuario)) {
            
            ps.setInt(1, this.iduser);
            
            try (java.sql.ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String nombreBD = rs.getString("User_name");
                    String emailBD = rs.getString("e_mail");
                    jMenuItem1.setText(nombreBD);
                    jMenuItem2.setText(emailBD);
                } else {
                    jMenuItem1.setText(" Desconocido");
                    jMenuItem1.setText("Desconocido");
                }
            }
        } catch (java.sql.SQLException ex) {
            logger.log(java.util.logging.Level.SEVERE, "Error al buscar el nombre o correo del usuario", ex);
            jMenuItem1.setText("Error BD");
            jMenuItem2.setText("Error BD");
        }
        
    }
    
    
    public javax.swing.JPanel getJPanel3() {
        return this.jPanel3;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnback = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnmenu = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();

        jMenuItem1.addActionListener(this::jMenuItem1ActionPerformed);
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("jMenuItem2");
        jPopupMenu1.add(jMenuItem2);

        jMenuItem3.setText("Cerrar Sesion");
        jMenuItem3.addActionListener(this::jMenuItem3ActionPerformed);
        jPopupMenu1.add(jMenuItem3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(199, 221, 181));

        jPanel2.setBackground(new java.awt.Color(27, 77, 47));
        jPanel2.setForeground(new java.awt.Color(27, 77, 47));

        btnback.addActionListener(this::btnbackActionPerformed);

        jLabel2.setFont(new java.awt.Font("Sylfaen", 0, 48)); // NOI18N
        jLabel2.setText("Verde Smart");

        btnmenu.addActionListener(this::btnmenuActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnback)
                .addGap(28, 28, 28)
                .addComponent(jButton2)
                .addGap(61, 61, 61)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158)
                .addComponent(btnmenu)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnmenu, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAdd.addActionListener(this::btnAddActionPerformed);

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
                        .addComponent(btnAdd))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(554, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(58, 58, 58)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
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

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        ADD1 add = new ADD1(this, this.iduser); 
        add.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        login2 log = new login2();
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnbackActionPerformed

    private void btnmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenuActionPerformed
        jPopupMenu1.setLightWeightPopupEnabled(false); 
        jPopupMenu1.show(btnmenu, 0, btnmenu.getHeight());
    }//GEN-LAST:event_btnmenuActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        profile P = new profile(iduser);
        P.setVisible(true);
        this.dispose();
       
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        LOGIN LOG = new LOGIN();
        LOG.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnback;
    private javax.swing.JButton btnmenu;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

   public int getIdUser(){
        return this.iduser;
    }
}
