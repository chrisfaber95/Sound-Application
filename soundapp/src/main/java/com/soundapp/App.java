package com.soundapp;

import javax.swing.JFrame;

import com.soundapp.components.fileloader.Fileloader;
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
        MainFrame mainframe = new MainFrame();
        Soundblock soundblock = new Soundblock();
        Fileloader fileloader = new Fileloader();
        System.out.println(mainframe);
        JFrame frame = mainframe.getFrame();
        frame.getContentPane().add(soundblock.getGui());
        frame.getContentPane().add(fileloader.getGui());
        frame.setVisible(true);
    }
}
