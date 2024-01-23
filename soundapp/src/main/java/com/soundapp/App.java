package com.soundapp;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.soundapp.components.soundblock.Gui;
import com.soundapp.components.soundblock.Soundblock;
import com.soundapp.gui.MainFrame;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        MainFrame mainframe = new MainFrame();
        Soundblock soundblock = new Soundblock();
        System.out.println(mainframe);
        JFrame frame = mainframe.getFrame();
        frame.getContentPane().add(soundblock.getGui());
        frame.setVisible(true);
    }
}
