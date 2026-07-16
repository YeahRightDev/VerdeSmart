package com.mycompany.verdesmart;

import java.awt.geom.Ellipse2D;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;
import java.awt.Image;

/**
 * ROUND_PANEL Class.
 * A custom Swing JPanel designed to render a perfectly circular profile component layout.
 * It features anti-aliased geometry drawing and supports setting a background clip mask for images.
 */
public class ROUND_PANEL extends JPanel {
    private Image imagen; // Holds the image reference to be rendered inside the circular mask

    // Holds the image reference to be rendered inside the circular mask
    public ROUND_PANEL() {
        this.setOpaque(false);
        this.setBackground(new Color(0, 0, 0, 0));
    }
    /**
     * Assigns a custom background element image and forces a UI repaint update cycle.
     */
    public void setImage(Image imagen) {
        this.imagen = imagen;
        this.repaint(); 
    }
    @Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    
    Graphics2D g2 = (Graphics2D) g;
    // Enable anti-aliasing for smooth circular edge vectors
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    
    // Dynamically calculate uniform dimensions based on component bounds
    int diameter = Math.min(getWidth(), getHeight());
    int x = (getWidth() - diameter) / 2;
    int y = (getHeight() - diameter) / 2;
    
    // Render the default solid light-pink backing base circle surface
    g2.setColor(new Color(245, 171, 185)); 
    g2.fillOval(x, y, diameter, diameter);

    // If an image asset exists, apply the circular clip mask and draw it
    if (imagen != null) {
        java.awt.Shape clipOriginal = g2.getClip(); // Save the original graphics clip state
        
        // Define the elliptical geometry bounds for the custom boundary mask
        Ellipse2D.Double circuloRecorte = new Ellipse2D.Double(x, y, diameter, diameter);
        g2.setClip(circuloRecorte); // Apply the circular clip mask
        
        // Draw the image scaled to match the calculated diameter dimensions
        g2.drawImage(imagen, x, y, diameter, diameter, this);
        
        g2.setClip(clipOriginal); // Restore the original graphics clip state
    }
}
}