package com.mycompany.verdesmart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * PLANTS Frame class.
 * Handles the selection of different plant species to assign to a specific garden 
 * instance, interacting directly with the database to maintain relational records.
 */
public class PLANTS extends javax.swing.JFrame {
    
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PLANTS.class.getName());
    private grounds mainScreen;          // Reference to the main control dashboard frame
    private int idGarden;                // Internal unique identifier for the targeted garden
    private String gardenName;           // Text name of the current working garden
    private String gardenArea;           // Text measurement area of the garden
    private int iduser;
    // Tracking Collections for Selection States 
    private List<Integer> selectedPlantIds = new ArrayList<>();
    private List<String> selectedPlantNames = new ArrayList<>();
    /**
     * Initializes a new PLANTS frame layout context linked to a garden dataset.
     */
   public PLANTS(grounds groundsScreen, int idGarden, String groundName, String groundArea,int idUser){
        initComponents();
        this.setSize(800,700);
        this.mainScreen = groundsScreen;
        this.idGarden = idGarden;
        this.gardenName = groundName;
        this.gardenArea = groundArea;
        this.iduser = idUser;
   
        // Remove standard native borders and selection fills for standard buttons
        jButton1.setContentAreaFilled(false); 
        jButton1.setBorderPainted(false);     
        jButton1.setFocusPainted(false);  
        
        jButton2.setContentAreaFilled(false); 
        jButton2.setBorderPainted(false);     
        jButton2.setFocusPainted(false);  
        
        jButton3.setContentAreaFilled(false); 
        jButton3.setBorderPainted(false);     
        jButton3.setFocusPainted(false);  
        
        // Apply FlatLaf look and feel styles for modern visual designs
        jButton4.putClientProperty("FlatLaf.style",
        "background:#1B5E20;" +
        "foreground:#FFFFFF;" +
        "borderWidth:0;" +
        "focusWidth:0;" +
        "arc:999;");
        btnCoronaCristo.putClientProperty("FlatLaf.style",
        "background:#C7DDB5");
        
       btnArbolAbundancia.putClientProperty("FlatLaf.style",
        "background:#C7DDB5");
       
       btnDiffenbachia.putClientProperty("FlatLaf.style",
        "background:#C7DDB5");
       
       btnDurantia.putClientProperty("FlatLaf.style",
        "background:#C7DDB5");

        btnSave.setPreferredSize(new java.awt.Dimension(40, 40));
        btnSave.setSize(42, 42);
        btnSave.putClientProperty("FlatLaf.style", "background: #1B4D2F; arc: 999; borderWidth: 0; focusWidth: 0;");
        
        // Apply rounded design using FlatLaf capabilities natively
        jPanel3.putClientProperty("FlatLaf.style", "arc: 30; background: #FFFFFF;");
        jPanel3.setOpaque(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnDiffenbachia = new javax.swing.JButton();
        btnArbolAbundancia = new javax.swing.JButton();
        btnCoronaCristo = new javax.swing.JButton();
        btnDurantia = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(199, 221, 181));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(27, 77, 47));

        jButton1.addActionListener(this::jButton1ActionPerformed);

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
                .addGap(54, 54, 54)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(323, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jButton2))
                .addGap(8, 8, 8))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, -1));

        jButton3.addActionListener(this::jButton3ActionPerformed);
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(27, 77, 47));
        jLabel3.setText("-----------------------------------------");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 250, 40));
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, -1, -1));

        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        btnDiffenbachia.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        btnDiffenbachia.setText(" Diffenbachia                                                                                                  ");
        btnDiffenbachia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDiffenbachia.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnDiffenbachia.addActionListener(this::btnDiffenbachiaActionPerformed);

        btnArbolAbundancia.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        btnArbolAbundancia.setText("Arbol abundancia                                                                                ");
        btnArbolAbundancia.setToolTipText("");
        btnArbolAbundancia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnArbolAbundancia.addActionListener(this::btnArbolAbundanciaActionPerformed);

        btnCoronaCristo.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        btnCoronaCristo.setText("Corona de Cristo                                                                                ");
        btnCoronaCristo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCoronaCristo.addActionListener(this::btnCoronaCristoActionPerformed);

        btnDurantia.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        btnDurantia.setText("Durantia                                                                                                         ");
        btnDurantia.addActionListener(this::btnDurantiaActionPerformed);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDurantia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDiffenbachia, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnCoronaCristo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnArbolAbundancia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(btnCoronaCristo)
                .addGap(49, 49, 49)
                .addComponent(btnDiffenbachia)
                .addGap(49, 49, 49)
                .addComponent(btnArbolAbundancia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(btnDurantia)
                .addGap(33, 33, 33))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 181, 710, 390));

        jLabel4.setFont(new java.awt.Font("Sylfaen", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(27, 77, 47));
        jLabel4.setText("Plantas");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, -1, -1));

        btnSave.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        btnSave.setText("Guardar");
        btnSave.addActionListener(this::btnSaveActionPerformed);
        jPanel1.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 600, 190, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 804, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Triggered when selecting "Árbol de la Abundancia".
     * Assigns a hardcoded ID instance and tracks validation selections.
     */
    private void btnArbolAbundanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArbolAbundanciaActionPerformed

         String plantName = "Árbol abundancia";

    // 1. Validar en la lista local de la sesión actual
    if (selectedPlantNames.contains(plantName)) {
        javax.swing.JOptionPane.showMessageDialog(this, "Ya seleccionaste esta planta en esta sesión.");
        return;
    }

    try {
        Connection con = DatabaseConnection.getInstance().getConnection();
        int plantId = -1;

        // 2. Verificar si la planta YA existe en la tabla general 'plant'
        String checkPlantSql = "SELECT id_Plant FROM plant WHERE Plant_Name = ?";
        try (PreparedStatement pstCheck = con.prepareStatement(checkPlantSql)) {
            pstCheck.setString(1, plantName);
            try (ResultSet rs = pstCheck.executeQuery()) {
                if (rs.next()) {
                    plantId = rs.getInt("id_Plant"); // La planta ya existía en la BD
                }
            }
        }

        // 3. Si NO existe en el catálogo, la insertamos (sin pasar id_Garden)
        if (plantId == -1) {
            String insertPlantSql = "INSERT INTO plant (Plant_Name, Species, Necessary_Water_Litres, " +
                    "Necessary_Space_SqM, Weather_Min_Temp, Region, Plant_Type, Plant_Description) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement pstInsert = con.prepareStatement(insertPlantSql, Statement.RETURN_GENERATED_KEYS)) {
            pstInsert.setString(1, plantName);
            pstInsert.setString(2, "Portulacaria afra");
            pstInsert.setFloat(3, 0.3f);
            pstInsert.setFloat(4, 0.5f);
            pstInsert.setFloat(5, 5.0f);
            pstInsert.setString(6, "Sudáfrica");
            pstInsert.setString(7, "Suculenta / Arbusto perenne");
            pstInsert.setString(8, "Arbusto suculento de hojas pequeñas, carnosas y brillantes con tallos rojizos. Muy resistente a la sequía y símbolo de la prosperidad.");
     

                pstInsert.executeUpdate();
                try (ResultSet generatedKeys = pstInsert.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        plantId = generatedKeys.getInt(1);
                    }
                }
            }
        }

        // 4. Verificar si esta planta ya está vinculada a ESTE jardín en la BD
        String checkGardenPlantSql = "SELECT id_Garden_Plant FROM garden_plant WHERE id_Plant = ? AND id_Garden = ?";
        try (PreparedStatement pstGP = con.prepareStatement(checkGardenPlantSql)) {
            pstGP.setInt(1, plantId);
            pstGP.setInt(2, this.idGarden);
            try (ResultSet rsGP = pstGP.executeQuery()) {
                if (rsGP.next()) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Esta planta ya está registrada en este jardín.");
                    return; // Detener flujo
                }
            }
        }

        // 5. Si todo está bien, la agregamos a nuestras listas locales para el guardado final
        selectedPlantIds.add(plantId);
        selectedPlantNames.add(plantName);
        javax.swing.JOptionPane.showMessageDialog(this, "Planta '" + plantName + "' seleccionada correctamente.");

    } catch (SQLException e) {
        logger.log(java.util.logging.Level.SEVERE, "Error al procesar planta", e);
        javax.swing.JOptionPane.showMessageDialog(this, "Error de base de datos: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
           
    
    }//GEN-LAST:event_btnArbolAbundanciaActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
     if (selectedPlantIds.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Please select at least one plant.", "Warning", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    String sql = "INSERT INTO garden_plant (id_Plant, id_Garden) VALUES (?, ?)";
    
    try (Connection con = DatabaseConnection.getInstance().getConnection();
         PreparedStatement pst = con.prepareStatement(sql)) {
        
        for (int plantId : selectedPlantIds) {
            pst.setInt(1, plantId);
            pst.setInt(2, this.idGarden); 
            pst.addBatch(); 
        }
        
        pst.executeBatch(); 

        if (this.mainScreen != null) {
            String plantsFormattedText = String.join(", ", selectedPlantNames);
            GroundCard newCard = new GroundCard(this.idGarden, gardenName, gardenArea, plantsFormattedText,iduser);
            
            // Set explicit card sizes
            newCard.setMaximumSize(new java.awt.Dimension(650, 150));
            newCard.setPreferredSize(new java.awt.Dimension(650, 150));
            newCard.setMinimumSize(new java.awt.Dimension(650, 150));
            newCard.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
            
            // TARGET CONTAINER CONFIGURATION: 
            // We force the main container panel to be non-opaque so it doesn't draw a gray square background under our card
            javax.swing.JPanel targetPanel = this.mainScreen.getJPanel3();
            targetPanel.setOpaque(false); 
            
            // Add the component
            targetPanel.add(newCard);
            targetPanel.add(javax.swing.Box.createVerticalStrut(10)); 
            
            // Force Layout Validation UI recalculation
            targetPanel.revalidate();
            targetPanel.repaint();
            this.mainScreen.revalidate();
            this.mainScreen.repaint();
        }
        
        javax.swing.JOptionPane.showMessageDialog(this, "¡El jardín se ha configurado y guardado correctamente!");
        this.mainScreen.setVisible(true);
        this.dispose();

    } catch (SQLException e) {
            logger.log(java.util.logging.Level.SEVERE, "Error al insertar planta", e);
            javax.swing.JOptionPane.showMessageDialog(this, "Se ha producido una excepción de base de datos: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

   
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       ADD1 add = new ADD1(this.mainScreen, this.mainScreen.getIdUser());
        add.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       ADD1 addWindow = new ADD1(this.mainScreen, this.mainScreen.getIdUser());
        addWindow.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnCoronaCristoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCoronaCristoActionPerformed
                                                
    String plantName = "Corona de Cristo";

    // 1. Validar en la lista local de la sesión actual
    if (selectedPlantNames.contains(plantName)) {
        javax.swing.JOptionPane.showMessageDialog(this, "Ya seleccionaste esta planta en esta sesión.");
        return;
    }

    try {
        Connection con = DatabaseConnection.getInstance().getConnection();
        int plantId = -1;

        // 2. Verificar si la planta YA existe en la tabla general 'plant'
        String checkPlantSql = "SELECT id_Plant FROM plant WHERE Plant_Name = ?";
        try (PreparedStatement pstCheck = con.prepareStatement(checkPlantSql)) {
            pstCheck.setString(1, plantName);
            try (ResultSet rs = pstCheck.executeQuery()) {
                if (rs.next()) {
                    plantId = rs.getInt("id_Plant"); // La planta ya existía en la BD
                }
            }
        }

        // 3. Si NO existe en el catálogo, la insertamos (sin pasar id_Garden)
        if (plantId == -1) {
            String insertPlantSql = "INSERT INTO plant (Plant_Name, Species, Necessary_Water_Litres, " +
                    "Necessary_Space_SqM, Weather_Min_Temp, Region, Plant_Type, Plant_Description) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement pstInsert = con.prepareStatement(insertPlantSql, Statement.RETURN_GENERATED_KEYS)) {
                pstInsert.setString(1, plantName);
                pstInsert.setString(2, "Euphorbia milii");
                pstInsert.setFloat(3, 0.5f);
                pstInsert.setFloat(4, 0.36f);
                pstInsert.setFloat(5, 10.0f);
                pstInsert.setString(6, "Madagascar");
                pstInsert.setString(7, "Suculenta / Arbusto");
                pstInsert.setString(8, "Arbusto espinoso muy resistente al sol directo.");

                pstInsert.executeUpdate();
                try (ResultSet generatedKeys = pstInsert.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        plantId = generatedKeys.getInt(1);
                    }
                }
            }
        }

        // 4. Verificar si esta planta ya está vinculada a ESTE jardín en la BD
        String checkGardenPlantSql = "SELECT id_Garden_Plant FROM garden_plant WHERE id_Plant = ? AND id_Garden = ?";
        try (PreparedStatement pstGP = con.prepareStatement(checkGardenPlantSql)) {
            pstGP.setInt(1, plantId);
            pstGP.setInt(2, this.idGarden);
            try (ResultSet rsGP = pstGP.executeQuery()) {
                if (rsGP.next()) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Esta planta ya está registrada en este jardín.");
                    return; // Detener flujo
                }
            }
        }

        // 5. Si todo está bien, la agregamos a nuestras listas locales para el guardado final
        selectedPlantIds.add(plantId);
        selectedPlantNames.add(plantName);
        javax.swing.JOptionPane.showMessageDialog(this, "Planta '" + plantName + "' seleccionada correctamente.");

    } catch (SQLException e) {
        logger.log(java.util.logging.Level.SEVERE, "Error al procesar planta", e);
        javax.swing.JOptionPane.showMessageDialog(this, "Error de base de datos: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_btnCoronaCristoActionPerformed

    private void btnDiffenbachiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiffenbachiaActionPerformed

                                                    
    String plantName = "Diffenbachia";

    // 1. Validar en la lista local de la sesión actual
    if (selectedPlantNames.contains(plantName)) {
        javax.swing.JOptionPane.showMessageDialog(this, "Ya seleccionaste esta planta en esta sesión.");
        return;
    }

    try {
        Connection con = DatabaseConnection.getInstance().getConnection();
        int plantId = -1;

        // 2. Verificar si la planta YA existe en la tabla general 'plant'
        String checkPlantSql = "SELECT id_Plant FROM plant WHERE Plant_Name = ?";
        try (PreparedStatement pstCheck = con.prepareStatement(checkPlantSql)) {
            pstCheck.setString(1, plantName);
            try (ResultSet rs = pstCheck.executeQuery()) {
                if (rs.next()) {
                    plantId = rs.getInt("id_Plant"); // La planta ya existía en la BD
                }
            }
        }

        // 3. Si NO existe en el catálogo, la insertamos (sin pasar id_Garden)
        if (plantId == -1) {
            String insertPlantSql = "INSERT INTO plant (Plant_Name, Species, Necessary_Water_Litres, " +
                    "Necessary_Space_SqM, Weather_Min_Temp, Region, Plant_Type, Plant_Description) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement pstInsert = con.prepareStatement(insertPlantSql, Statement.RETURN_GENERATED_KEYS)) {
                pstInsert.setString(1, plantName);
                pstInsert.setString(2, "Dieffenbachia seguine");
                pstInsert.setFloat(3, 0.8f);
                pstInsert.setFloat(4, 0.25f);
                pstInsert.setFloat(5, 15.0f);
                pstInsert.setString(6, "América Central y del Sur");
                pstInsert.setString(7, "Planta de Interior / Follaje");
                pstInsert.setString(8, "Planta tropical de interior con grandes hojas matizadas en tonos verdes y blancos.");
         

                pstInsert.executeUpdate();
                try (ResultSet generatedKeys = pstInsert.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        plantId = generatedKeys.getInt(1);
                    }
                }
            }
        }

        // 4. Verificar si esta planta ya está vinculada a ESTE jardín en la BD
        String checkGardenPlantSql = "SELECT id_Garden_Plant FROM garden_plant WHERE id_Plant = ? AND id_Garden = ?";
        try (PreparedStatement pstGP = con.prepareStatement(checkGardenPlantSql)) {
            pstGP.setInt(1, plantId);
            pstGP.setInt(2, this.idGarden);
            try (ResultSet rsGP = pstGP.executeQuery()) {
                if (rsGP.next()) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Esta planta ya está registrada en este jardín.");
                    return; // Detener flujo
                }
            }
        }

        // 5. Si todo está bien, la agregamos a nuestras listas locales para el guardado final
        selectedPlantIds.add(plantId);
        selectedPlantNames.add(plantName);
        javax.swing.JOptionPane.showMessageDialog(this, "Planta '" + plantName + "' seleccionada correctamente.");

    } catch (SQLException e) {
        logger.log(java.util.logging.Level.SEVERE, "Error al procesar planta", e);
        javax.swing.JOptionPane.showMessageDialog(this, "Error de base de datos: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
        
               
    }//GEN-LAST:event_btnDiffenbachiaActionPerformed

    private void btnDurantiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDurantiaActionPerformed
      
        
                                                    
    String plantName = "Durantia";

    // 1. Validar en la lista local de la sesión actual
    if (selectedPlantNames.contains(plantName)) {
        javax.swing.JOptionPane.showMessageDialog(this, "Ya seleccionaste esta planta en esta sesión.");
        return;
    }

    try {
        Connection con = DatabaseConnection.getInstance().getConnection();
        int plantId = -1;

        // 2. Verificar si la planta YA existe en la tabla general 'plant'
        String checkPlantSql = "SELECT id_Plant FROM plant WHERE Plant_Name = ?";
        try (PreparedStatement pstCheck = con.prepareStatement(checkPlantSql)) {
            pstCheck.setString(1, plantName);
            try (ResultSet rs = pstCheck.executeQuery()) {
                if (rs.next()) {
                    plantId = rs.getInt("id_Plant"); // La planta ya existía en la BD
                }
            }
        }

        // 3. Si NO existe en el catálogo, la insertamos (sin pasar id_Garden)
        if (plantId == -1) {
            String insertPlantSql = "INSERT INTO plant (Plant_Name, Species, Necessary_Water_Litres, " +
                    "Necessary_Space_SqM, Weather_Min_Temp, Region, Plant_Type, Plant_Description) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement pstInsert = con.prepareStatement(insertPlantSql, Statement.RETURN_GENERATED_KEYS)) {
                pstInsert.setString(1, plantName);
                pstInsert.setString(2, "Duranta erecta");
                pstInsert.setFloat(3, 1.5f);
                pstInsert.setFloat(4, 1.0f);
                pstInsert.setFloat(5, 10.0f);
                pstInsert.setString(6, "América Tropical");
                pstInsert.setString(7, "Arbusto de Exterior / Ornamental");
                pstInsert.setString(8, "Arbusto vigoroso ideal para cercas vivas. Produce hermosas flores moradas o azules en racimos.");
             

                pstInsert.executeUpdate();
                try (ResultSet generatedKeys = pstInsert.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        plantId = generatedKeys.getInt(1);
                    }
                }
            }
        }

        // 4. Verificar si esta planta ya está vinculada a ESTE jardín en la BD
        String checkGardenPlantSql = "SELECT id_Garden_Plant FROM garden_plant WHERE id_Plant = ? AND id_Garden = ?";
        try (PreparedStatement pstGP = con.prepareStatement(checkGardenPlantSql)) {
            pstGP.setInt(1, plantId);
            pstGP.setInt(2, this.idGarden);
            try (ResultSet rsGP = pstGP.executeQuery()) {
                if (rsGP.next()) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Esta planta ya está registrada en este jardín.");
                    return; // Detener flujo
                }
            }
        }

        // 5. Si todo está bien, la agregamos a nuestras listas locales para el guardado final
        selectedPlantIds.add(plantId);
        selectedPlantNames.add(plantName);
        javax.swing.JOptionPane.showMessageDialog(this, "Planta '" + plantName + "' seleccionada correctamente.");

    } catch (SQLException e) {
        logger.log(java.util.logging.Level.SEVERE, "Error al procesar planta", e);
        javax.swing.JOptionPane.showMessageDialog(this, "Error de base de datos: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
        
                
    }//GEN-LAST:event_btnDurantiaActionPerformed

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArbolAbundancia;
    private javax.swing.JButton btnCoronaCristo;
    private javax.swing.JButton btnDiffenbachia;
    private javax.swing.JButton btnDurantia;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

}
