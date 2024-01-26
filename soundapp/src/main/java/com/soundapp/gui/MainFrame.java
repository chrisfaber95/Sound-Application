package com.soundapp.gui;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class MainFrame {
    JFrame frame;
    public MainFrame(){
        frame = new JFrame("Title");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0, 2));
        frame.setSize(600, 300);
        frame.setVisible(true);
    }

    public JFrame getFrame(){
        return frame;
    }
}
