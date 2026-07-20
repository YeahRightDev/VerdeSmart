package com.mycompany.verdesmart;

import javax.swing.ImageIcon;

public class login2 extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(login2.class.getName());

    /**
     * Creates a new instance form of login2.
     * Manages window boundaries, establishes FlatLaf placeholders, resolves application branding assets, 
     * strips native button decoration contexts, and applies anti-aliased border configurations.
     */
    int iduser;
    public login2() {
        initComponents();

        this.setSize(800, 700);
        this.setLocationRelativeTo(null);

       // Inject inline context guidance text placeholders using FlatLaf engine keys
        txtCorreo.putClientProperty("FlatLaf.placeholderText", "Email");
        txtPassword.putClientProperty("FlatLaf.placeholderText", "Password");

        // Load image
      try {
            java.net.URL imagePath = getClass().getResource("/imagenes/icono.jpeg");

            if (imagePath != null) {
                ImageIcon icon = new ImageIcon(imagePath);
                rOUND_PANEL1.setImage(icon.getImage());
            } else {
                System.out.println("ERROR: Image not found");
            }

        } catch (Exception e) {
            System.out.println("Image loading error: " + e.getMessage());
        }
        // Configure transparent interaction behaviors across navigation button instances
        jButton1.setContentAreaFilled(false);
        jButton1.setBorderPainted(false);
        jButton1.setFocusPainted(false);

        btnback.setContentAreaFilled(false);
        btnback.setBorderPainted(false);
        btnback.setFocusPainted(false);

        btnlogin.setPreferredSize(new java.awt.Dimension(40, 40));
        btnlogin.putClientProperty(
                "FlatLaf.style",
                "background:#1B4D2F; arc:999; borderWidth:0; focusWidth:0;"
        );

        // Apply interactive behavior properties for the recovery access action button link
        btnpassword.setPreferredSize(new java.awt.Dimension(40, 40));
        btnpassword.setContentAreaFilled(false);
        btnpassword.setBorderPainted(false);
        btnpassword.setFocusPainted(false);

        // Enforce anti-aliased geometry overrides across text input structures5
        styleRoundedField(txtCorreo);
        styleRoundedField(txtPassword);
    }

    
    private void styleRoundedField(javax.swing.JTextField field) {

        field.setOpaque(true);
        field.setBackground(java.awt.Color.WHITE);

        field.setBorder(new javax.swing.border.AbstractBorder() {

            @Override
            public void paintBorder(java.awt.Component c,
                                    java.awt.Graphics g,
                                    int x,
                                    int y,
                                    int width,
                                    int height) {

                java.awt.Graphics2D g2 = (java.awt.Graphics2D) g.create();

                g2.setRenderingHint(
                        java.awt.RenderingHints.KEY_ANTIALIASING,
                        java.awt.RenderingHints.VALUE_ANTIALIAS_ON
                );

                java.awt.Container parent = c.getParent();

                if (parent != null) {
                    g2.setColor(parent.getBackground());

                    java.awt.geom.Area outside =
                            new java.awt.geom.Area(
                                    new java.awt.Rectangle(x, y, width, height));

                    outside.subtract(
                            new java.awt.geom.Area(
                                    new java.awt.geom.RoundRectangle2D.Float(
                                            x, y, width, height, 15, 15)));

                    g2.fill(outside);
                }

                g2.setColor(new java.awt.Color(180, 180, 180));
                g2.drawRoundRect(x, y, width - 1, height - 1, 15, 15);

                g2.dispose();
            }

            @Override
            public java.awt.Insets getBorderInsets(java.awt.Component c) {
                return new java.awt.Insets(6, 12, 6, 12);
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnback = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnlogin = new javax.swing.JButton();
        btnpassword = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        rOUND_PANEL1 = new com.mycompany.verdesmart.ROUND_PANEL();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(199, 221, 181));

        jPanel2.setBackground(new java.awt.Color(27, 77, 47));

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Brith\\Documents\\GitHub\\VerdeSmart\\src\\main\\resources\\imagenes\\hojas-de-coca (1).png")); // NOI18N

        jLabel1.setFont(new java.awt.Font("Sylfaen", 0, 36)); // NOI18N
        jLabel1.setText("Verde Smart");

        btnback.setIcon(new javax.swing.ImageIcon("C:\\Users\\Brith\\Documents\\GitHub\\VerdeSmart\\src\\main\\resources\\imagenes\\atras.png")); // NOI18N
        btnback.addActionListener(this::btnbackActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnback)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnback)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Sylfaen", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(27, 77, 47));
        jLabel2.setText("Inicio Sesión");

        jLabel3.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(27, 77, 47));
        jLabel3.setText("Correo Electrónico");

        txtCorreo.setColumns(67);
        txtCorreo.setBorder(
            new javax.swing.border.AbstractBorder() { @Override public void paintBorder(java.awt.Component c, java.awt.Graphics g, int x, int y, int width, int height) { java.awt.Graphics2D g2 = (java.awt.Graphics2D) g; g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON); g2.setColor(java.awt.Color.GRAY); g2.drawRoundRect(x, y, width - 1, height - 1, 15, 15); } @Override public java.awt.Insets getBorderInsets(java.awt.Component c) { return new java.awt.Insets(4, 10, 4, 10); } });

        jLabel4.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(27, 77, 47));
        jLabel4.setText("Contraseña");

        btnlogin.setText("Iniciar Sesión");
        btnlogin.addActionListener(this::btnloginActionPerformed);

        btnpassword.setText("Olvidé Contraseña");
        btnpassword.addActionListener(this::btnpasswordActionPerformed);

        txtPassword.setColumns(67);

        javax.swing.GroupLayout rOUND_PANEL1Layout = new javax.swing.GroupLayout(rOUND_PANEL1);
        rOUND_PANEL1.setLayout(rOUND_PANEL1Layout);
        rOUND_PANEL1Layout.setHorizontalGroup(
            rOUND_PANEL1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 201, Short.MAX_VALUE)
        );
        rOUND_PANEL1Layout.setVerticalGroup(
            rOUND_PANEL1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 168, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(297, 297, 297)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rOUND_PANEL1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(154, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rOUND_PANEL1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(27, 27, 27)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
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

    /**
     * Action handler triggered when the back navigation button (jButton2) is selected.
     * Restores window focus to the primary LOGIN layout workspace before disposing of this frame.
     */
    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        LOGIN nuevaVentana = new LOGIN();
        nuevaVentana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnbackActionPerformed

    /**
     * Action handler triggered when the primary login submit action button (jButton3) is clicked.
     * Validates field integrity, secures connection access, maps parameters against active parameters,
     * and forwards successful authentication tokens to the grounds visual dashboard frame.
     */
    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
        String Email = txtCorreo.getText().trim();
        String Password = new String(txtPassword.getPassword()).trim();

        if (Email.isEmpty() || Password.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, llena todos los campos.");
            return;
        }

        try {
            java.sql.Connection con = DatabaseConnection.getInstance().getConnection();
            if (con != null) {
                String sql = "SELECT * FROM users WHERE e_mail = ? AND User_Password = ?";
                try (java.sql.PreparedStatement pst = con.prepareStatement(sql)) {
                
                    pst.setString(1, Email);
                    pst.setString(2, Password);

                    try (java.sql.ResultSet rs = pst.executeQuery()) {
                        
                        if (rs.next()) {
                            this.iduser = rs.getInt("id_User");
                            javax.swing.JOptionPane.showMessageDialog(this, "¡Bienvenido!" );
                            grounds CARD = new grounds(this.iduser);
                            CARD.setVisible(true);
                            this.dispose();
                        } else {
                            javax.swing.JOptionPane.showMessageDialog(this, "Correo o contrasena incorrectos.");
                        }
                    }
                }
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Error: No hay conexion con la base de datos.");
            }
        } catch (java.sql.SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error de base de datos: " + e.getMessage());
        }
    }//GEN-LAST:event_btnloginActionPerformed

    private void btnpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpasswordActionPerformed
    forgotten_password password = new forgotten_password(iduser);
    password.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_btnpasswordActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnback;
    private javax.swing.JButton btnlogin;
    private javax.swing.JButton btnpassword;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.mycompany.verdesmart.ROUND_PANEL rOUND_PANEL1;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
