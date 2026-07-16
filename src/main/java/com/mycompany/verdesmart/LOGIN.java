package com.mycompany.verdesmart;

import javax.swing.ImageIcon;
/**
 * LOGIN Main Frame for the VerdeSmart application.
 * Manages user authentication, navigation to registration, and view initializations.
 */
public class LOGIN extends javax.swing.JFrame {
    
    // Logger instance for tracking login activity and potential exceptions
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LOGIN.class.getName());
    /**
     * Creates new form LOGIN
     */
    public LOGIN() {
       
        initComponents();
        
        // Window sizing and screen centering settings
        this.setSize(800, 700);
        this.setLocationRelativeTo(null); 
        
        try {
           
            // Retrieve the application logo resource from the project structure
            java.net.URL rutaImg = getClass().getResource("/imagenes/icono.jpeg");
            
            if (rutaImg != null) {
                ImageIcon iconoOriginal = new ImageIcon(rutaImg);
                
                // Assign the image to the custom rounded panel component
                rOUND_PANEL1.setImage(iconoOriginal.getImage());
                System.out.println("Imagen asignada con éxito a panelredondo1");
            } else {
                System.out.println("ERROR: No se encontró el archivo en /imagenes/icono.jpeg");
            }
        } catch (Exception e) {
            System.out.println("Error al cargar la imagen: " + e.getMessage());
        }
        
        
        // Button 1: Sign In styling via FlatLaf look and feel configuration
        logIn.putClientProperty("FlatLaf.style", ""
                + "background: #1B4D2F;"
                + "foreground: #FFFFFF;"
                + "borderWidth: 0;"
                + "focusWidth: 0;"
                + "arc: 999;");   

        // Botón 2: Crear Cuenta
        newAcc.putClientProperty("FlatLaf.style", ""
                + "background: #1B4D2F;"
                + "foreground: #FFFFFF;"
                + "borderWidth: 0;"
                + "focusWidth: 0;"
                + "arc: 999;");

        // Botón 3: Salir
        Exit.putClientProperty("FlatLaf.style", ""
                + "background: #EF9FBC;"
                + "foreground: #000000;"
                + "borderWidth: 0;"
                + "focusWidth: 0;"
                + "arc: 999;");

}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        newAcc = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        logIn = new javax.swing.JButton();
        rOUND_PANEL1 = new com.mycompany.verdesmart.ROUND_PANEL();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(199, 221, 181));

        jPanel2.setBackground(new java.awt.Color(27, 77, 47));

        jLabel2.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Instrucciones");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Sylfaen", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(27, 77, 47));
        jLabel1.setText("Verde Smart");

        newAcc.setBackground(new java.awt.Color(217, 206, 159));
        newAcc.setText("Crear cuenta");
        newAcc.addActionListener(this::newAccActionPerformed);

        Exit.setText("Salir");
        Exit.addActionListener(this::ExitActionPerformed);

        logIn.setBackground(new java.awt.Color(27, 77, 47));
        logIn.setText("Iniciar Sesión");
        logIn.addActionListener(this::logInActionPerformed);

        javax.swing.GroupLayout rOUND_PANEL1Layout = new javax.swing.GroupLayout(rOUND_PANEL1);
        rOUND_PANEL1.setLayout(rOUND_PANEL1Layout);
        rOUND_PANEL1Layout.setHorizontalGroup(
            rOUND_PANEL1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 295, Short.MAX_VALUE)
        );
        rOUND_PANEL1Layout.setVerticalGroup(
            rOUND_PANEL1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 229, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(logIn, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(80, 80, 80))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(rOUND_PANEL1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rOUND_PANEL1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(logIn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(newAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(153, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Triggered when the user clicks 'Iniciar Sesión'.
     * Displays the credential input window and disposes of this welcome screen.
     */
    private void logInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logInActionPerformed
        login2 nuevaVentana = new login2();
        nuevaVentana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logInActionPerformed

    /**
     * Triggered when the user clicks 'Crear cuenta'.
     * Displays the account generation window and disposes of this welcome screen.
     */
    private void newAccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newAccActionPerformed
        // TODO add your handling code here:
        Create_account create = new Create_account();
        create.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_newAccActionPerformed

    /**
     * Triggered when the user clicks 'Salir'.
     * Completely terminates the application execution environment.
     */
    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        System.exit(0); 
    }//GEN-LAST:event_ExitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton logIn;
    private javax.swing.JButton newAcc;
    private com.mycompany.verdesmart.ROUND_PANEL rOUND_PANEL1;
    // End of variables declaration//GEN-END:variables
}
