package com.mycompany.verdesmart;

import javafx.application.Platform;
import javafx.concurrent.Worker;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import netscape.javascript.JSObject;

import java.io.File;
import java.io.FileWriter;
import javax.swing.*;
import java.awt.*;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.logging.Logger;
import java.util.logging.Level;

public class ADD1 extends javax.swing.JFrame {
    private grounds mainScreen;
    private int idUser;
    
    public ADD1(grounds main_scren,int idUser) { 
        this.Main_scren = main_scren;
        this.iduser = idUser;
        initComponents();
        
        // Setting the default dimensions for the frame
        this.setSize(800, 705);
        
        // Making button backgrounds, borders, and focus rings transparent/hidden for a cleaner UI
        btnback.setContentAreaFilled(false); 
        btnback.setBorderPainted(false);     
        btnback.setFocusPainted(false);  
        
        jButton2.setContentAreaFilled(false); 
        jButton2.setBorderPainted(false);     
        jButton2.setFocusPainted(false);  
        
        
        
        // Styling a button using FlatLaf LookAndFeel client properties (custom background, colors, and fully rounded shape)
        btnpage.putClientProperty("FlatLaf.style",
        "background:#1B5E20;" +
        "foreground:#FFFFFF;" +
        "borderWidth:0;" +
        "focusWidth:0;" +
        "arc:999;");
        btnpage2.setContentAreaFilled(false); 
        btnpage2.setBorderPainted(false);     
        btnpage2.setFocusPainted(false);  
        
        jButton7.setContentAreaFilled(false); 
        jButton7.setBorderPainted(false);     
        jButton7.setFocusPainted(false);  
        
        // Defining dimensions and specific roundness attributes for navigation or control buttons
        btnclose.setPreferredSize(new java.awt.Dimension(40, 40));
        btnclose.setSize(42, 42);
        btnclose.putClientProperty("FlatLaf.style", "background: #1B4D2F; arc: 999; borderWidth: 0; focusWidth: 0;");
        
        btnnext.setPreferredSize(new java.awt.Dimension(40, 40));
        btnnext.setSize(42, 42);
        btnnext.putClientProperty("FlatLaf.style", "background: #1B4D2F; arc: 999; borderWidth: 0; focusWidth: 0;");
        
        
        textname.setPreferredSize(new java.awt.Dimension(400, 37));
        textname.setMinimumSize(new java.awt.Dimension(200, 37));
        
        
        jPanel3.revalidate();
        jPanel3.repaint();
        
        // Customizing main content containers with a rounded corner factor of 30 pixels
        jPanel3.putClientProperty("FlatLaf.style", "arc: 30;");
    }
    //
    private static final Logger logger = Logger.getLogger(ADD1.class.getName());
    
    private JavaBridge miPuente = new JavaBridge();
    private int idGardenGenerado;
    
    // ========================================================
    // ¡ESTO ES CLAVE! Variable global para que Java no borre el puente
    // ========================================================
   

    
    public ADD1() {
       
       // setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        jPanel1 = new JPanel();
        jPanel1.setLayout(new BorderLayout());

        cargarWebView();

        this.add(jPanel1);
    }

    // CLASE PUENTE
    public class JavaBridge {
        public void guardarArchivo(String nombre, String contenidoJson) {
            System.out.println("JS llamó a Java exitosamente. Abriendo ventana de guardado...");
            
            SwingUtilities.invokeLater(() -> {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Guardar Proyecto Verde Smart");
                fileChooser.setSelectedFile(new File(nombre + ".json"));
                
                int userSelection = fileChooser.showSaveDialog(ADD1.this);
                
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();
                    try (FileWriter fw = new FileWriter(fileToSave)) {
                        fw.write(contenidoJson);
                        JOptionPane.showMessageDialog(ADD1.this, 
                            "Proyecto guardado exitosamente en:\n" + fileToSave.getAbsolutePath(), 
                            "Guardado Exitoso", JOptionPane.INFORMATION_MESSAGE);
                        System.out.println("Archivo guardado en: " + fileToSave.getAbsolutePath());
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(ADD1.this, 
                            "Error al guardar el archivo: " + e.getMessage(), 
                            "Error", JOptionPane.ERROR_MESSAGE);
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("El usuario canceló el guardado.");
                }
            });
        }
    }

    private void cargarWebView() {
        JFXPanel fxPanel = new JFXPanel();
        jPanel1.add(fxPanel, BorderLayout.CENTER);

        Platform.runLater(() -> {
            WebView webView = new WebView();
            WebEngine webEngine = webView.getEngine();
            
            webView.setContextMenuEnabled(false);
            webView.setFocusTraversable(true);
            
            webView.addEventFilter(MouseEvent.MOUSE_PRESSED, event -> {
                webView.requestFocus();
            });

            webView.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
                if (event.getCode() == KeyCode.ENTER) {
                    try {
                        Object handled = webEngine.executeScript("window.forzarEnter();");
                        if (Boolean.TRUE.equals(handled)) { event.consume(); }
                    } catch (Exception ex) { }
                } 
                else if (event.getCode() == KeyCode.BACK_SPACE || event.getCode() == KeyCode.DELETE) {
                    try {
                        Object handled = webEngine.executeScript("window.forzarBorrar();");
                        if (Boolean.TRUE.equals(handled)) { event.consume(); }
                    } catch (Exception ex) { }
                }
            });
            Button btnRegresar = new Button("⬅ Regresar");
            
            // Estilo flotante: fondo semitransparente u opaco, bordes redondeados y cursor de mano
            btnRegresar.setStyle(
                "-fx-background-color: rgba(40, 40, 40, 0.85);" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 12px;" +
                "-fx-padding: 8px 12px;" +
                "-fx-background-radius: 6px;" +
                "-fx-cursor: hand;" +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.4), 6, 0, 0, 2);"
            );
            

                                                  

            btnRegresar.setOnAction(e -> {
               if (webEngine.getHistory().getCurrentIndex() > 0) {
                webEngine.getHistory().go(-1);
             }
            });
            
           btnRegresar.setOnAction(e -> {
    SwingUtilities.invokeLater(() -> {
        // 1. Obtenemos el nombre ingresado por el usuario
        String nombreJardin = textname.getText().trim();
        if (nombreJardin.isEmpty()) {
            nombreJardin = "Mi Jardín";
        }
        
        // 2. Instanciamos PLANTS pasándole el ID real que MySQL generó en el INSERT
        PLANTS vistaPlantas = new PLANTS(
            this.Main_scren, 
            this.idGardenGenerado, // <-- ¡AQUÍ SE ENVÍA EL ID GENERADO!
            nombreJardin, 
            "0m2", 
            this.iduser
        );
        
        vistaPlantas.setVisible(true);
        this.dispose();
    });
});
            StackPane root = new StackPane();
            
            root.getChildren().add(webView);
            
            // 2. Añadimos el botón encima y lo posicionamos (ej. Arriba a la Izquierda con márgenes)
            root.getChildren().add(btnRegresar);
            StackPane.setAlignment(btnRegresar, Pos.TOP_LEFT);
            StackPane.setMargin(btnRegresar, new Insets(15, 0, 0, 15)); // Margen superior e izquierdo de 15px

            webEngine.getLoadWorker().stateProperty().addListener((obs, oldState, newState) -> {
                if (newState == Worker.State.SUCCEEDED) {
                    System.out.println("Página cargada. Inyectando el puente Java-JS...");
                    JSObject window = (JSObject) webEngine.executeScript("window");
                    window.setMember("javaBridge", miPuente); 
                }
            });
            try {
                java.net.URL url = getClass().getResource("/web/jardin.html");
                if (url != null) {
                    String urlLocal = url.toURI().toURL().toExternalForm();
                    webEngine.load(urlLocal);
                    System.out.println("HTML cargado correctamente desde recursos.");
                } else {
                    System.err.println("ERROR: No se encontró el HTML.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Asignamos el StackPane con el botón flotante a la escena
            Scene scene = new Scene(root);
            fxPanel.setScene(scene);
        });
    }

    // Reference to the main screen/frame of the application
    private grounds Main_scren;
    private int iduser;
    /**
     * Constructor of the class. Initializes UI components, window size, 
     * and sets custom FlatLaf styles and styling behaviors.
     */
    

    /**
     * Custom method to design and paint standard text fields with rounded borders.
     * It handles background transparency fixes, anti-aliasing, and customized pixel-by-pixel border drawing.
     */
    private void roundfield(javax.swing.JTextField campo, String placeholderText) {
     campo.putClientProperty("Component.roundRect", true);
     campo.putClientProperty("FlatLaf.style", 
            "background: #FFFFFF;" +
            "borderColor: #B4B4B4;" +
            "focusedBorderColor: #1B4D2F;" +
            "arc: 15;");
     campo.putClientProperty("FlatLaf.placeholderText", placeholderText);
    campo.setMargin(new java.awt.Insets(5, 10, 5, 10));
     campo.setMargin(new java.awt.Insets(5, 10, 5, 10));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnback = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnpage = new javax.swing.JButton();
        btnpage2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textname = new javax.swing.JTextField();
        btnclose = new javax.swing.JButton();
        btnnext = new javax.swing.JButton();

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(199, 221, 181));

        jPanel2.setBackground(new java.awt.Color(27, 77, 47));

        btnback.addActionListener(this::btnbackActionPerformed);

        jLabel1.setFont(new java.awt.Font("Sylfaen", 0, 36)); // NOI18N
        jLabel1.setText("Verde Smart");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnback)
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
                    .addComponent(btnback, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(27, 77, 47));
        jLabel2.setText("Agregar Terreno");

        btnpage.setBackground(new java.awt.Color(27, 77, 47));

        jLabel3.setForeground(new java.awt.Color(27, 77, 47));
        jLabel3.setText("-----------------------------------------");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(27, 77, 47));
        jLabel4.setText("Medidas");

        jLabel5.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(27, 77, 47));
        jLabel5.setText("Nombre");

        textname.setColumns(60);

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
                            .addComponent(jLabel5)
                            .addComponent(textname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(42, 42, Short.MAX_VALUE))
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
                .addComponent(textname, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(231, Short.MAX_VALUE))
        );

        btnclose.setText("Cerrar");
        btnclose.addActionListener(this::btncloseActionPerformed);

        btnnext.setText("Siguente");
        btnnext.addActionListener(this::btnnextActionPerformed);

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
                                .addComponent(btnpage)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnpage2)))))
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(btnclose, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnnext, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(btnpage)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel3))))
                    .addComponent(btnpage2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnnext, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnclose, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
       // TODO add your handling code here:
        if (this.Main_scren != null) {
        this.Main_scren.setVisible(true);
    }
    this.dispose();    

    }//GEN-LAST:event_btnbackActionPerformed

    //btn back
    
    private void btncloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncloseActionPerformed
   if (this.Main_scren != null) {
        this.Main_scren.setVisible(true);
    }
    this.dispose();
    }//GEN-LAST:event_btncloseActionPerformed

    /**
     * Action event handler for Button 6 ("Siguiente" / Next). 
     * Validates numeric input values, calculates the field area, connects to the database using 
     * the Singleton pattern, updates SQL entries, captures auto-generated keys, and triggers the next view.
     */
    private void btnnextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnextActionPerformed
                                         
    String nombre = textname.getText().trim();
    Double totalArea = 0.0;

    if (nombre.isEmpty()) {
        JOptionPane.showMessageDialog(this,
                "Por favor, ingrese el nombre que tendrá el terreno / jardín.",
                "Campo requerido",
                JOptionPane.WARNING_MESSAGE);
        return;
    }

    String sql = "INSERT INTO garden (Garden_Name, Total_Area, Shape, Soil_Type, Humidity, id_User) VALUES (?, ?, ?, ?, ?, ?)";

    try {
        Connection con = DatabaseConnection.getInstance().getConnection();

        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, nombre);
            ps.setDouble(2, totalArea);
            ps.setString(3, "Rectangular");
            ps.setString(4, "Normal");
            ps.setDouble(5, 0.0);
            ps.setInt(6, this.iduser);

            int filasInsertadas = ps.executeUpdate();

            if (filasInsertadas > 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        idGardenGenerado = generatedKeys.getInt(1);
                    }
                }

                JOptionPane.showMessageDialog(this, "¡Jardín guardado exitosamente!");

                // CORRECCIÓN: Limpiamos el panel principal y cargamos el WebView dinámicamente
                jPanel1.removeAll();
                jPanel1.setLayout(new BorderLayout());
                cargarWebView();
                jPanel1.revalidate();
                jPanel1.repaint();
            }
        }
    } catch (SQLException ex) {
        logger.log(Level.SEVERE, "Error al insertar el jardín", ex);
        JOptionPane.showMessageDialog(this, "Error al guardar en la base de datos: " + ex.getMessage(),
                "Error SQL", JOptionPane.ERROR_MESSAGE);
    
}
    }//GEN-LAST:event_btnnextActionPerformed

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
}
private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
   
    btnnextActionPerformed(evt);
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnback;
    private javax.swing.JButton btnclose;
    private javax.swing.JButton btnnext;
    private javax.swing.JButton btnpage;
    private javax.swing.JButton btnpage2;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField textname;
    // End of variables declaration//GEN-END:variables
}
