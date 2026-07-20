package com.mycompany.verdesmart;

public class ADD1 extends javax.swing.JFrame {

    // Logger instance to register and trace internal errors or system operations
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ADD1.class.getName());
    // Reference to the main screen/frame of the application
    private grounds Main_scren;
    private int iduser;
    /**
     * Constructor of the class. Initializes UI components, window size, 
     * and sets custom FlatLaf styles and styling behaviors.
     */
    public ADD1(grounds main_scren,int idUser) {
        this.Main_scren = main_scren;
        this.iduser = idUser;
        initComponents();
        
        // Setting the default dimensions for the frame
        this.setSize(800, 705);
        
        // Making button backgrounds, borders, and focus rings transparent/hidden for a cleaner UI
        jButton1.setContentAreaFilled(false); 
        jButton1.setBorderPainted(false);     
        jButton1.setFocusPainted(false);  
        
        jButton2.setContentAreaFilled(false); 
        jButton2.setBorderPainted(false);     
        jButton2.setFocusPainted(false);  
        
        // Styling a button using FlatLaf LookAndFeel client properties (custom background, colors, and fully rounded shape)
        jButton3.putClientProperty("FlatLaf.style",
        "background:#1B5E20;" +
        "foreground:#FFFFFF;" +
        "borderWidth:0;" +
        "focusWidth:0;" +
        "arc:999;");
        jButton4.setContentAreaFilled(false); 
        jButton4.setBorderPainted(false);     
        jButton4.setFocusPainted(false);  
        
        jButton7.setContentAreaFilled(false); 
        jButton7.setBorderPainted(false);     
        jButton7.setFocusPainted(false);  
        
        // Defining dimensions and specific roundness attributes for navigation or control buttons
        jButton5.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton5.setSize(42, 42);
        jButton5.putClientProperty("FlatLaf.style", "background: #1B4D2F; arc: 999; borderWidth: 0; focusWidth: 0;");
        
        jButton6.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton6.setSize(42, 42);
        jButton6.putClientProperty("FlatLaf.style", "background: #1B4D2F; arc: 999; borderWidth: 0; focusWidth: 0;");
        
        // Applying custom rounded border styles to all text fields
        roundfield(btnName);
        roundfield(jTextField2);
        
        btnName.setPreferredSize(new java.awt.Dimension(400, 37));
        btnName.setMinimumSize(new java.awt.Dimension(200, 37));
        
        jTextField2.setPreferredSize(new java.awt.Dimension(120, 35));
        jTextField2.setMinimumSize(new java.awt.Dimension(100, 35));
        
        
        jPanel3.revalidate();
        jPanel3.repaint();
        
        // Customizing main content containers with a rounded corner factor of 30 pixels
        jPanel3.putClientProperty("FlatLaf.style", "arc: 30;");
        jPanel4.putClientProperty("FlatLaf.style", "arc: 30;");
    }

    /**
     * Custom method to design and paint standard text fields with rounded borders.
     * It handles background transparency fixes, anti-aliasing, and customized pixel-by-pixel border drawing.
     */
    private void roundfield(javax.swing.JTextField campo) {
     campo.putClientProperty("Component.roundRect", true);
     campo.putClientProperty("FlatLaf.style", 
            "background: #FFFFFF;" +
            "borderColor: #B4B4B4;" +
            "focusedBorderColor: #1B4D2F;" +
            "arc: 15;");
     campo.setMargin(new java.awt.Insets(5, 10, 5, 10));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnName = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        jLabel6.setText("jLabel6");

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
                .addGap(18, 18, 18)
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
                        .addComponent(jLabel1))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(27, 77, 47));
        jLabel2.setText("Agregar Terreno");

        jButton3.setBackground(new java.awt.Color(27, 77, 47));
        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Brith\\Documents\\GitHub\\VerdeSmart\\src\\main\\resources\\imagenes\\matematicas.png")); // NOI18N

        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Brith\\Documents\\GitHub\\VerdeSmart\\src\\main\\resources\\imagenes\\dos.png")); // NOI18N

        jLabel3.setForeground(new java.awt.Color(27, 77, 47));
        jLabel3.setText("-----------------------------------------");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(27, 77, 47));
        jLabel4.setText("Medidas");

        jLabel5.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(27, 77, 47));
        jLabel5.setText("Nombre");

        btnName.setColumns(60);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 695, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 254, Short.MAX_VALUE)
        );

        jLabel8.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(27, 77, 47));
        jLabel8.setText("Medidas");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnName, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addGap(25, 25, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

        jButton5.setText("Cerrar");
        jButton5.addActionListener(this::jButton5ActionPerformed);

        jButton6.setText("Siguente");
        jButton6.addActionListener(this::jButton6ActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4)))))
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel3))))
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       // TODO add your handling code here:
        if (this.Main_scren != null) {
        this.Main_scren.setVisible(true);
    }
    this.dispose();    

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
   if (this.Main_scren != null) {
        this.Main_scren.setVisible(true);
    }
    this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * Action event handler for Button 6 ("Siguiente" / Next). 
     * Validates numeric input values, calculates the field area, connects to the database using 
     * the Singleton pattern, updates SQL entries, captures auto-generated keys, and triggers the next view.
     */
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        System.out.println("Intentando guardar jardín para el usuario " + this.iduser);
        String nombre;
        Double totalArea;
        // Extract inputs from GUI text elements and remove empty white spaces
    
    // 1. Data parsing and validation of numeric field bounds
    try {
        nombre = btnName.getText().trim();
        totalArea = 0.0;
    } catch (NumberFormatException e) {
        // Show error notification window if inputs are not real valid numbers
        javax.swing.JOptionPane.showMessageDialog(this, "Por favor, ingresael nombr del terreno.", "Error de formato", javax.swing.JOptionPane.ERROR_MESSAGE);
        return; 
    }

    // 2. Map structural SQL query command
    String sql = "INSERT INTO garden (Garden_Name, Total_Area, Shape, Soil_Type, Humidity, id_User) VALUES ( ?, ?, ?, ?, ?, ?)";
    // 3. Conectar usando tu Singleton
    try {
        java.sql.Connection con = DatabaseConnection.getInstance().getConnection();
        
        // AÑADIDO: Le decimos al PreparedStatement que queremos recuperar las llaves generadas automáticamente
        try (java.sql.PreparedStatement ps = con.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS)) {
            
            ps.setString(1, nombre);
            ps.setDouble(2, totalArea); //por el momento
            ps.setString(3, "Rectangular");
            ps.setString(4, "Normal");   
            ps.setDouble(5, 0.0); 
            ps.setInt(6, this.iduser); 

            // Ejecutar la inserción
            int filasInsertadas = ps.executeUpdate();
            
            if (filasInsertadas > 0) {
                int idGardenGenerado = 0;
                
                // 3. Open connection via custom Database Singleton and apply records
                try (java.sql.ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        idGardenGenerado = generatedKeys.getInt(1);
                    }
                }

                javax.swing.JOptionPane.showMessageDialog(this, "¡Terreno registrado con éxito en la base de datos!");
                
                // CORREGIDO: Ahora sí le pasamos los 4 parámetros requeridos, incluyendo el ID real
                PLANTS ventanaPlantas = new PLANTS(this.Main_scren, idGardenGenerado, nombre, String.valueOf(totalArea),this.iduser);
                ventanaPlantas.setVisible(true);
                this.dispose(); 
            }
        }
    } catch (java.sql.SQLException ex) {
        // Trace database exceptions via local logging stack trace system
        logger.log(java.util.logging.Level.SEVERE, "Error al insertar el jardín", ex);
        javax.swing.JOptionPane.showMessageDialog(this, "Error al guardar en la base de datos: " + ex.getMessage(), "Error SQL", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
   /**
     * Inner helper class defining a customized UI Panel structure.
     * Manages canvas dimensions, overrides painting operations, and activates smooth rendering to display layout containers with round-shaped edges.
     */
class roundpanel extends javax.swing.JPanel {
    private int radio;
    public roundpanel(int radio) {
        this.radio = radio;
        setOpaque(false); 
    }
    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        java.awt.Graphics2D g2d = (java.awt.Graphics2D) g;
        g2d.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(getBackground());
        g2d.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radio, radio);
    }
}private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
   
    jButton6ActionPerformed(evt);
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField btnName;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
