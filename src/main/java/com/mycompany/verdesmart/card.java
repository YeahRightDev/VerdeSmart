package com.mycompany.verdesmart;

public class card extends javax.swing.JPanel {

    public card() {
        initComponents();
    }

    public card(String name, String area, String plant) {
        initComponents(); 
        this.jLabel1.setText(name);  
        this.jLabel2.setText(area);  
        this.jLabel3.setText(plant); 
    }


    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        setLayout(new java.awt.GridLayout(3, 1, 5, 5));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        jLabel1.setText("Nombre");
        add(jLabel1);

        jLabel2.setText("Área");
        add(jLabel2);

        jLabel3.setText("Planta");
        add(jLabel3);
    }

    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
}