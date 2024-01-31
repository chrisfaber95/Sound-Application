package com.soundapp.gui;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class MainFrame {
    JFrame frame;
    public MainFrame(){
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

        frame = new JFrame("Title");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(gd.getDisplayMode().getWidth()/2, gd.getDisplayMode().getHeight()/2);
        frame.setLayout(new GridLayout(0, 2));
        frame.setVisible(true);
    }

    public JFrame getFrame(){
        return frame;
    }
}
