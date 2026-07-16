package com.mycompany.verdesmart;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * forgotten_password Frame Class.
 * Handles the user verification and password update lifecycle workflow within the system.
 * It uses a two-step validation model: first matching user email records from the database,
 * and subsequently granting safe write-access updates to cleartext credentials.
 */
public class forgotten_password extends javax.swing.JFrame {

    private boolean emailVerified = false;// Internal structural gate tracking if step 1 validation passed

    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(forgotten_password.class.getName());

    /**
     * Creates new form forgotten_password.
     * Establishes look-and-feel configurations, placeholders, and structural locks.
     */
    public forgotten_password() {
        initComponents();

        // Enforce dedicated frame boundaries
        this.setSize(800, 700);

       // UI Element Properties & FlatLaf Layout Placeholders
        mailTxt.putClientProperty("FlatLaf.placeholderText", "Email");
        newPassword.putClientProperty("FlatLaf.placeholderText", "New Password");
        confPassword.putClientProperty("FlatLaf.placeholderText", "Confirm Password");

       // Transparent Top Header Navigation Buttons
        jButton1.setContentAreaFilled(false);
        jButton1.setBorderPainted(false);
        jButton1.setFocusPainted(false);

        jButton2.setContentAreaFilled(false);
        jButton2.setBorderPainted(false);
        jButton2.setFocusPainted(false);

        // Step 1: Email Verification Submission UI Setup
        jButton4.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton4.setSize(42, 42);
        jButton4.putClientProperty("FlatLaf.style",
                "background:#1B4D2F; arc:999; borderWidth:0; focusWidth:0;");

        // Step 2: Password Modification Confirmation UI Setup
        jButton3.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton3.setSize(42, 42);
        jButton3.putClientProperty("FlatLaf.style",
                "background:#1B4D2F; arc:999; borderWidth:0; focusWidth:0;");

        // Apply visual round border clipping rules across custom fields
        styleRoundedField(mailTxt);
        styleRoundedField(newPassword);
        styleRoundedField(confPassword);

       // Security Lock: Keep modification fields disabled until email verification completes
        newPassword.setEnabled(false);
        confPassword.setEnabled(false);
        jButton3.setEnabled(false);
    }

   /**
     * Dynamically injects antialiased borders and corner radii configurations 
     * matching custom parent component layouts.
     */
    private void styleRoundedField(javax.swing.JTextField field) {

        field.setOpaque(true);
        field.setBackground(java.awt.Color.WHITE);

        // Placeholder
        if (field == mailTxt) {
            field.putClientProperty("FlatLaf.placeholderText", "Email");
        }

        field.setBorder(new javax.swing.border.AbstractBorder() {

            @Override
            public void paintBorder(java.awt.Component c,
                                    java.awt.Graphics g,
                                    int x,
                                    int y,
                                    int width,
                                    int height) {

                java.awt.Graphics2D g2 =
                        (java.awt.Graphics2D) g.create();

                g2.setRenderingHint(
                        java.awt.RenderingHints.KEY_ANTIALIASING,
                        java.awt.RenderingHints.VALUE_ANTIALIAS_ON);

                java.awt.Container parent = c.getParent();

                if (parent != null) {

                    g2.setColor(parent.getBackground());

                    java.awt.geom.Area outside =
                            new java.awt.geom.Area(
                                    new java.awt.Rectangle(x, y, width, height));

                    outside.subtract(
                            new java.awt.geom.Area(
                                    new java.awt.geom.RoundRectangle2D.Float(
                                            x,
                                            y,
                                            width,
                                            height,
                                            15,
                                            15)));

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
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        newPassword = new javax.swing.JPasswordField();
        confPassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        mailTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(199, 221, 181));

        jPanel2.setBackground(new java.awt.Color(27, 77, 47));

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Brith\\Documents\\GitHub\\VerdeSmart\\src\\main\\resources\\imagenes\\atras.png")); // NOI18N
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Brith\\Documents\\GitHub\\VerdeSmart\\src\\main\\resources\\imagenes\\hojas-de-coca (1).png")); // NOI18N

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
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Sylfaen", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(27, 77, 47));
        jLabel2.setText("Recuperar contraseña");

        newPassword.setColumns(60);

        confPassword.setColumns(60);

        jLabel3.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(27, 77, 47));
        jLabel3.setText("Contraseña Nueva");

        jLabel4.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(27, 77, 47));
        jLabel4.setText("Confirmar");

        jButton3.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        jButton3.setText("Guardar");
        jButton3.setToolTipText("");
        jButton3.addActionListener(this::jButton3ActionPerformed);

        mailTxt.setColumns(60);

        jLabel6.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(27, 77, 47));
        jLabel6.setText("Correo");

        jButton4.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        jButton4.setText("Confirmar ");
        jButton4.addActionListener(this::jButton4ActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(252, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(221, 221, 221))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(confPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(335, 335, 335)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(27, 27, 27)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(confPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Action handler for Step 2 (Save Button).
     * Validates matching configurations, checks field constraints, edits matching user rows 
     * from database schema, and transitions window frames back to Login view context.
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (!emailVerified) {
            JOptionPane.showMessageDialog(this, "First verify your email.");
            return;
        }

        String pass = newPassword.getText();
        String confirm = confPassword.getText();

        if (pass.isEmpty() || confirm.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Fill both password fields.");
            return;
        }

        if (!pass.equals(confirm)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match.");
            return;
        }

        if (pass.length() < 8) {
            JOptionPane.showMessageDialog(this, "Password must be at least 8 characters.");
            return;
        }

        String sql = "UPDATE users SET User_Password = ? WHERE e_mail = ?";

        try {
            Connection con = DatabaseConnection.getInstance().getConnection();
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, pass);
                ps.setString(2, mailTxt.getText().trim());
                
                ps.executeUpdate();
                
                JOptionPane.showMessageDialog(this,
                        "Password updated successfully.");
                
                login2 log = new login2();
                log.setVisible(true);
                this.dispose();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * Action handler for the Back button.
     * Closes the recovery frame and reverts display visibility to the login window layout.
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        login2 loginWindow = new login2();
        loginWindow.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Action handler for Step 1 (Confirm/Verify Email Button).
     * Parses the field string against standard email regex patterns, performs a database
     * lookup query, and enables password edit fields upon finding a structural record match.
     */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String email = mailTxt.getText().trim();
        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduce tu correo electrónico.");
            return;
        }

        // Basic structural validation check via modern regex string pattern matching loops
        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            JOptionPane.showMessageDialog(this, "Formato de correo electrónico no válido.");
            return;
        }

        String sql = "SELECT * FROM users WHERE e_mail = ?";

        try {
            Connection con = DatabaseConnection.getInstance().getConnection();
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, email);
                
                ResultSet rs = ps.executeQuery();
                
                if (rs.next()) {
                    
                    emailVerified = true;
                    
                    JOptionPane.showMessageDialog(this,
                            "Correo electrónico verificado. Ahora introduce tu nueva contraseña.");
                    
                    // Unlock entry capabilities across sub-layer password fields
                    newPassword.setEnabled(true);
                    confPassword.setEnabled(true);
                    jButton3.setEnabled(true);
                    
                    // Lock down baseline identity components once successfully checked
                    mailTxt.setEnabled(false);
                    jButton4.setEnabled(false);
                    
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Email not found.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                
                rs.close();
            }

        } catch (SQLException e) {
            logger.log(java.util.logging.Level.SEVERE, "DB error", e);
            JOptionPane.showMessageDialog(this, "Error de base de datos: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField confPassword;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField mailTxt;
    private javax.swing.JPasswordField newPassword;
    // End of variables declaration//GEN-END:variables
}
