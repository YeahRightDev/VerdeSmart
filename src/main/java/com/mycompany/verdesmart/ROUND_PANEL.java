package com.mycompany.verdesmart;

import java.awt.geom.Ellipse2D;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;
import java.awt.Image;
public class ROUND_PANEL extends JPanel {
    private Image imagen;
    public ROUND_PANEL() {
        this.setOpaque(false);
        this.setBackground(new Color(0, 0, 0, 0));
    }
    public void setImage(Image imagen) {
        this.imagen = imagen;
        this.repaint(); 
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int diameter = Math.min(getWidth(), getHeight());
        int x = (getWidth() - diameter) / 2;
        int y = (getHeight() - diameter) / 2;
        
        // Dibuja el fondo circular rosa
        g2.setColor(new Color(245, 171, 185)); 
        g2.fillOval(x, y, diameter, diameter);

        // Si hay una imagen, la recorta en forma de círculo y la dibuja
        if (imagen != null) {
            java.awt.Shape clipOriginal = g2.getClip();
            
            Ellipse2D.Double circuloRecorte = new Ellipse2D.Double(x, y, diameter, diameter);
            g2.setClip(circuloRecorte);
            
            g2.setColor(getBackground()); 
            g2.fillOval(x, y, diameter, diameter);
        }
    }
}