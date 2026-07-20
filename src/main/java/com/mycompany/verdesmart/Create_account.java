package com.mycompany.verdesmart;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 * Account creation window for the VerdeSmart application.
 * Manages user registration UI and database insertion.
 */
public class Create_account extends javax.swing.JFrame {
    
    // Logger instance for error tracking and debugging within the class
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Create_account.class.getName());
    
    /**
     * Creates new form Create_account and initializes customized UI styling.
     */
    public Create_account() {
        initComponents();
        this.setSize(800, 700);// Set window layout dimensions

        // Apply custom rounded borders and backgrounds to text fields
        styleRoundedField(txtNombre);
        styleRoundedField(txtEdad);
        styleRoundedField(birthDateField);
        styleRoundedField(emailField);
        styleRoundedField(passwordField);
        styleRoundedField(confirmPasswordField);

        // Make top navigation and icon buttons transparent by disabling default backgrounds and focus outlines
        jButton1.setContentAreaFilled(false);
        jButton1.setBorderPainted(false);
        jButton1.setFocusPainted(false);

        jButton2.setContentAreaFilled(false);
        jButton2.setBorderPainted(false);
        jButton2.setFocusPainted(false);

        
        // Configure FlatLaf styling properties for the logIn button (making it circular with dark green background)
        logIn.setPreferredSize(new java.awt.Dimension(40, 40));
        logIn.setSize(42, 42);
        logIn.putClientProperty(
                "FlatLaf.style",
                "background:#1B4D2F; arc:999; borderWidth:0; focusWidth:0;"
        );
        // Configure identical FlatLaf circular styling properties for the alternative registerButton
        registerButton.setPreferredSize(new java.awt.Dimension(40, 40));
        registerButton.setSize(42, 42);
        registerButton.putClientProperty(
                "FlatLaf.style",
                "background:#1B4D2F; arc:999; borderWidth:0; focusWidth:0;"
        );

        // Adjust remaining visual parameters for the registerButton component
        registerButton.setContentAreaFilled(false);
        registerButton.setBorderPainted(false);
        registerButton.setFocusPainted(false);
        registerButton.setPreferredSize(new java.awt.Dimension(40, 40));
       
        
    }
   
    /**
     * Helper method to dynamically render rounded borders and apply custom text field placeholders.
     */
    private void styleRoundedField(javax.swing.JTextField field) {
        field.setOpaque(true);
        field.setBackground(java.awt.Color.WHITE);

        // Initialize inline localized placeholder values via FlatLaf library attributes
        txtNombre.putClientProperty("FlatLaf.placeholderText", "Name");
        birthDateField.putClientProperty("FlatLaf.placeholderText", "00");
        birthDateField.putClientProperty("FlatLaf.placeholderText", "YYYY-MM-DD");
        emailField.putClientProperty("FlatLaf.placeholderText", "Email");
        passwordField.putClientProperty("FlatLaf.placeholderText", "••••••••");
        confirmPasswordField.putClientProperty("FlatLaf.placeholderText", "••••••••");

        // Override default rendering pipeline to paint manual modern anti-aliased text boundaries
        field.setBorder(new javax.swing.border.AbstractBorder() {

            @Override
            public void paintBorder(java.awt.Component c,
                                    java.awt.Graphics g,
                                    int x,
                                    int y,
                                    int width,
                                    int height) {

                java.awt.Graphics2D g2 = (java.awt.Graphics2D) g.create();

                // Smooth edges out utilizing runtime anti-aliasing rendering hints
                g2.setRenderingHint(
                        java.awt.RenderingHints.KEY_ANTIALIASING,
                        java.awt.RenderingHints.VALUE_ANTIALIAS_ON);

                java.awt.Container parent = c.getParent();

                if (parent != null) {
                    // Subtract area bounds to blend field edges seamlessly with background panels
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

                // Draw external light gray outline stroke path
                g2.setColor(new java.awt.Color(180, 180, 180));
                g2.drawRoundRect(x, y, width - 1, height - 1, 15, 15);

                g2.dispose();
            }

            @Override
            public java.awt.Insets getBorderInsets(java.awt.Component c) {
                // Return internal component padding values to offset plain text fields properly
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
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        birthDateField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        confirmPasswordField = new javax.swing.JPasswordField();
        logIn = new javax.swing.JButton();
        registerButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(199, 221, 181));

        jPanel2.setBackground(new java.awt.Color(27, 77, 47));

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Brith\\Documents\\GitHub\\VerdeSmart\\src\\main\\resources\\imagenes\\atras.png")); // NOI18N
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Brith\\Documents\\GitHub\\VerdeSmart\\src\\main\\resources\\imagenes\\hojas-de-coca (1).png")); // NOI18N

        jLabel1.setFont(new java.awt.Font("Sylfaen", 0, 36)); // NOI18N
        jLabel1.setText(" Verde Smart");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(27, 77, 47));
        jLabel2.setText("Crear Cuenta");

        txtNombre.setBackground(new java.awt.Color(102, 102, 102));
        txtNombre.setColumns(55);
        txtNombre.setBorder(null);
        txtNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNombreMouseClicked(evt);
            }
        });
        txtNombre.addActionListener(this::txtNombreActionPerformed);

        txtEdad.addActionListener(this::txtEdadActionPerformed);

        birthDateField.setColumns(60);
        birthDateField.setText("YYYY-MM-DD");
        birthDateField.addActionListener(this::birthDateFieldActionPerformed);

        emailField.setColumns(60);
        emailField.addActionListener(this::emailFieldActionPerformed);

        passwordField.setColumns(60);
        passwordField.addActionListener(this::passwordFieldActionPerformed);

        confirmPasswordField.setColumns(60);
        confirmPasswordField.addActionListener(this::confirmPasswordFieldActionPerformed);

        logIn.setText("Iniciar Sesion");
        logIn.addActionListener(this::logInActionPerformed);

        registerButton.setText("¿Ya tienes cuenta?");
        registerButton.addActionListener(this::registerButtonActionPerformed);

        jLabel3.setForeground(new java.awt.Color(27, 77, 47));
        jLabel3.setText("Nombre");

        jLabel5.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(27, 77, 47));
        jLabel5.setText("Fecha de Nacimiento");

        jLabel6.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(27, 77, 47));
        jLabel6.setText("Correo");

        jLabel7.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(27, 77, 47));
        jLabel7.setText("Contraseña");

        jLabel8.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(27, 77, 47));
        jLabel8.setText("Confirmar contraseña");

        jLabel9.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(27, 77, 47));
        jLabel9.setText("Edad");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(63, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3)
                                .addComponent(jLabel8)
                                .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)
                                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)
                                .addComponent(jLabel5)
                                .addComponent(birthDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(logIn, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(142, 142, 142))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(birthDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logIn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
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

    // Closes current frame and opens up the main LOGIN view
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        LOGIN log = new LOGIN();
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void confirmPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmPasswordFieldActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadActionPerformed

    private void birthDateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_birthDateFieldActionPerformed
        
    
    }//GEN-LAST:event_birthDateFieldActionPerformed

    private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFieldActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_emailFieldActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void logInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logInActionPerformed

        // 1. Mandatory input constraints evaluation
        if (txtNombre.getText().trim().isEmpty()
                || emailField.getText().trim().isEmpty()
                || String.valueOf(passwordField.getPassword()).trim().isEmpty()
                || String.valueOf(confirmPasswordField.getPassword()).trim().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Complete todos los campos.");
            return;
        }

        String email = emailField.getText().trim();

        // 2. Structural regular expression filter ensuring correct electronic mail mapping formats
        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            JOptionPane.showMessageDialog(this, "Introduce un correo electrónico válido.");
            return;
        }

        // 3. Confirm identical character sequence match across both password boxes
        if (!String.valueOf(passwordField.getPassword())
                .equals(String.valueOf(confirmPasswordField.getPassword()))) {

            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden.");
            return;
        }

        // 4. Length security policy verification (Must exceed 7 characters minimum)
        if (String.valueOf(passwordField.getPassword()).length() < 8) {

            JOptionPane.showMessageDialog(this, "La contraseña debe contener al menos 8 caracteres.");
            return;
        }

        // Target insertion parameterized query string
        String sql = "INSERT INTO users (User_name, User_Password, e_mail) VALUES (?, ?, ?)";

        try {

            // Establish database connection pool instance reference
            Connection con = DatabaseConnection.getInstance().getConnection();
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, txtNombre.getText().trim());
                ps.setString(2, String.valueOf(passwordField.getPassword()));
                ps.setString(3, email);
                
                ps.executeUpdate();
                
                JOptionPane.showMessageDialog(this, "Cuenta creada con éxito.");
            }

            LOGIN log = new LOGIN();
            log.setVisible(true);
            this.dispose();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());

        }
    }//GEN-LAST:event_logInActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        // TODO add your handling code here:
        login2 log = new login2();
        log.setVisible(true);
         this.dispose();
    }//GEN-LAST:event_registerButtonActionPerformed

    private void txtNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreMouseClicked
        // TODO add your handling code here:
         txtNombre.setText("");
    }//GEN-LAST:event_txtNombreMouseClicked
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField birthDateField;
    private javax.swing.JPasswordField confirmPasswordField;
    private javax.swing.JTextField emailField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton logIn;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JButton registerButton;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}