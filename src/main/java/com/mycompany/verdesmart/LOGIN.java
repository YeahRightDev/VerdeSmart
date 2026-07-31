package com.mycompany.verdesmart;
import javax.swing.ImageIcon;
import java.awt.Color;
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
        
        //For enter
        this.getRootPane().setDefaultButton(btnlogin);
        
        // Window sizing and screen centering settings
        this.setSize(800, 700);
        this.setLocationRelativeTo(null); 
        
     try {
     java.net.URL imagePath = getClass().getResource("/imagenes/icono.jpeg");
     if (imagePath != null) {
        ((ROUND_PANEL)jPanel3).setImage(new javax.swing.ImageIcon(imagePath).getImage());
    }
 } catch(Exception e) {
    System.out.println("Error al cargar imagen: " + e.getMessage());
 }
        
        // Button 1: Sign In styling via FlatLaf look and feel configuration
        btnlogin.putClientProperty("FlatLaf.style", ""
                + "background: #1B4D2F;"
                + "foreground: #FFFFFF;"
                + "borderWidth: 0;"
                + "focusWidth: 0;"
                + "arc: 999;");   

        // Button 2: create account
        btnnewAcc.putClientProperty("FlatLaf.style", ""
                + "background: #1B4D2F;"
                + "foreground: #FFFFFF;"
                + "borderWidth: 0;"
                + "focusWidth: 0;"
                + "arc: 999;");

        // Button:Exit
        btnExit.putClientProperty("FlatLaf.style", ""
                + "background: #EF9FBC;"
                + "foreground: #000000;"
                + "borderWidth: 0;"
                + "focusWidth: 0;"
                + "arc: 999;");
        
        
        
        //Button help
        btnquestions.putClientProperty("FlatLaf.style", ""
                + "background: 1B4D2F;"
                + "foreground: FFFFFF;"
                + "borderWidth: 0;"
                + "focusWidth: 0;"
                + "arc: 999;");
       
       //instructions for the app
       instructions.setText("Normalmente, muchos jardineros tienen problemas para saber el ");
       instructions.append("\ntamaño exacto de sus jardines de forma irregular y recordar qué  ");
       instructions.append("\nplantas plantaron, así como los horarios o días en que regaron su ");
       instructions.append("\njardín,  por eso Verde Smart s una app diseñada para ayudar y ");
       instructions.append("\n facilitar las tarea a todos  los jardineros. Verde Smart ayuda  ");
       instructions.append("\na los jardineros a conocer las medidas de su terreno irregular y "); 
       instructions.append("\nllevar un registro detallado del nombre del jardín, las plantas ");
       instructions.append("\nque contiene, recomendaciones para regar las plantas y el tipo de ");
       instructions.append("\nsuelo que tiene.");
       
       instructions.setOpaque(false);
       SPinstructions.setOpaque(false);
       SPinstructions.getViewport().setOpaque(false);
       SPinstructions.setBorder(null);
       instructions.setForeground(java.awt.Color.WHITE);
                               
                                       
                                               
                                                      
     
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnquestions = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        SPinstructions = new javax.swing.JScrollPane();
        instructions = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        btnnewAcc = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnlogin = new javax.swing.JButton();
        jPanel3 = new com.mycompany.verdesmart.ROUND_PANEL();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(199, 221, 181));

        jPanel2.setBackground(new java.awt.Color(27, 77, 47));

        jLabel2.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Introducción a verde smart:");

        btnquestions.setBackground(new java.awt.Color(239, 159, 188));
        btnquestions.setText("?");
        btnquestions.setOpaque(true);
        btnquestions.addActionListener(this::btnquestionsActionPerformed);

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("INSTRUCCIONES DE USO:");

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Verde Smart v1.0 |  Universidad Tecnológica de Calvillo");

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("¿Necesitas ayuda Técnica?");

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("UTC@verdesmart.com");

        SPinstructions.setBorder(null);

        instructions.setColumns(20);
        instructions.setLineWrap(true);
        instructions.setRows(5);
        instructions.setWrapStyleWord(true);
        instructions.setOpaque(false);
        SPinstructions.setViewportView(instructions);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(233, 233, 233)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnquestions, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel3)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(SPinstructions, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SPinstructions, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(69, 69, 69)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnquestions, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)))
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(38, 38, 38)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        jLabel1.setFont(new java.awt.Font("Sylfaen", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(27, 77, 47));
        jLabel1.setText("Verde Smart");

        btnnewAcc.setBackground(new java.awt.Color(217, 206, 159));
        btnnewAcc.setText("Crear cuenta");
        btnnewAcc.addActionListener(this::btnnewAccActionPerformed);

        btnExit.setText("Salir");
        btnExit.addActionListener(this::btnExitActionPerformed);

        btnlogin.setBackground(new java.awt.Color(27, 77, 47));
        btnlogin.setText("Iniciar Sesión");
        btnlogin.addActionListener(this::btnloginActionPerformed);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 213, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 197, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnnewAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(74, 74, 74))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(btnlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnnewAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
      login2 nuevaVentana = new login2();
      nuevaVentana.setVisible(true);
      this.dispose();
    }//GEN-LAST:event_btnloginActionPerformed

    /**
     * Triggered when the user clicks 'Crear cuenta'.
     * Displays the account generation window and disposes of this welcome screen.
     */
    private void btnnewAccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnewAccActionPerformed
        // TODO add your handling code here:
       Create_account create = new Create_account();
       create.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnnewAccActionPerformed

    /**
     * Triggered when the user clicks 'Salir'.
     * Completely terminates the application execution environment.
     */
    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        System.exit(0); 
    }//GEN-LAST:event_ExitActionPerformed

    private void logInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
       int answer = javax.swing.JOptionPane.showConfirmDialog(
        this, 
        "¿Estás seguro de que deseas salir de Verde Smart?", 
        "Confirmar Salida", 
        javax.swing.JOptionPane.YES_NO_OPTION, 
        javax.swing.JOptionPane.QUESTION_MESSAGE
        );
       if (answer == javax.swing.JOptionPane.YES_OPTION) {
        System.exit(0);
    }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnquestionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnquestionsActionPerformed
        // TODO add your handling code here:
        //We implement HTML for the styles
        

        String mensaje = "<html><body style='width: 300px; font-family: SansSerif;'>"
        + "<h2 style='color: #1B4D2F;'>Guía Rápida - Verde Smart</h2>"
        + "<p><b>1. Crear cuenta:</b> Si es tu primera vez, haz clic en el botón <i>'Crear cuenta'</i> e ingresa tus datos (nombre, edad, correo y contraseña).</p><br>"
        + "<p><b>2. Iniciar sesión:</b> Si ya tienes una cuenta, haz clic en el botón <i>'Iniciar Sesión'</i> para acceder.</p><br>"
        + "<p><b>3. Recuperar contraseña:</b> Si olvidaste tu contraseña, podrás restablecerla con tu correo electrónico.</p>"
        + "</body></html>";

        
        
        javax.swing.JOptionPane.showMessageDialog(
            this, 
            mensaje, 
            "Instrucciones de Uso", 
            javax.swing.JOptionPane.INFORMATION_MESSAGE
    );
    }//GEN-LAST:event_btnquestionsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane SPinstructions;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnlogin;
    private javax.swing.JButton btnnewAcc;
    private javax.swing.JButton btnquestions;
    private javax.swing.JTextArea instructions;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
