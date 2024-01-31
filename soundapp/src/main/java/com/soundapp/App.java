package com.soundapp;

import javax.swing.JFrame;

import com.soundapp.components.fileloader.Fileloader;
import com.soundapp.components.playlist.PlaylistManager;
import com.soundapp.components.soundblock.Soundblock;
import com.soundapp.gui.MainFrame;

public class App 
{
    public static void main( String[] args )
    {
        MainFrame mainframe = new MainFrame();
        PlaylistManager playlist = new PlaylistManager();
        Soundblock soundblock = new Soundblock(playlist);
        Fileloader fileloader = new Fileloader(playlist);
        JFrame frame = mainframe.getFrame();
        frame.getContentPane().add(playlist.getGui());
        frame.getContentPane().add(fileloader.getGui());
        frame.getContentPane().add(soundblock.getGui());
        frame.setVisible(true);
    }
}
