package com.soundapp.components.soundblock;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

public class Timeline extends JComponent{
    
    private int x_location = 0;

    public Timeline(int x_location){
        this.x_location = x_location;
        setPreferredSize(new Dimension(500, 200));
    }

    public void updateMarkerLocation(int x){
        this.x_location = x;
        repaint();
    }

    public int get_x_location(){
        return x_location;
    }

    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawLine(g);
        drawMarker(g);
    }

    @Override
    public void repaint(){
        super.repaint();
    }

    
    private void drawLine(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Dimension d = this.getSize();
        System.out.println(this.getSize());
        
        g2d.setColor(Color.BLACK);
        g2d.drawLine(0, d.height / 2, d.width, d.height / 2);
    }

    private void drawMarker(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        Dimension d = this.getSize();
        g2d.setColor(Color.DARK_GRAY);
        g2d.drawOval(x_location, d.height / 2 - 5, 10, 10);
    }
}
