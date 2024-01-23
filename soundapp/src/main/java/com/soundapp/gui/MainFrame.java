package com.soundapp.gui;

import javax.swing.JFrame;

public class MainFrame {
    JFrame frame;
    public MainFrame(){
        frame = new JFrame("Title");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.setVisible(true);
    }

    public JFrame getFrame(){
        return frame;
    }
}
