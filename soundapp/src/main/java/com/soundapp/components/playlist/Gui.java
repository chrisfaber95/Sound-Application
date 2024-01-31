package com.soundapp.components.playlist;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.io.File;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Gui extends JPanel{
    
    private PlaylistManager parent;
    private JPanel playlistPanel;
    private JScrollPane scroller;

    Gui(PlaylistManager parent){
        this.parent = parent;
        setLayout(new BorderLayout());
        add(initTitle(), BorderLayout.NORTH);
        scroller = new JScrollPane(initPlaylistPanel());
        scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scroller, BorderLayout.CENTER);

        reloadPlaylist();
    }

    private JLabel initTitle(){
        JLabel title = new JLabel("Playlist");
        title.setLocation(0, 0);
        title.setMinimumSize(new Dimension(this.getWidth(), 20));
        title.setFont(new Font(null, Font.BOLD, 15));

        return title;
    }

    private JPanel initPlaylistPanel(){
        playlistPanel = new JPanel();
        playlistPanel.setLayout(new BoxLayout(playlistPanel, BoxLayout.Y_AXIS));
        playlistPanel.setBackground(Color.WHITE);
        
        return playlistPanel;
    }

    protected void reloadPlaylist(){
        playlistPanel.removeAll();
        List<File> playlist = this.parent.getPlaylist();
        for (int i = 0; i < playlist.size(); i++) {
            playlistPanel.add(new JLabel(String.format("%d - %s", i + 1, playlist.get(i).getName())));
        }
        revalidate();
        repaint();
    }

    protected void addToPlaylist(Integer index, String url){
        playlistPanel.add(new JLabel(
            "%s - %s".formatted(index.toString(), url))
        );
        revalidate();
        repaint();
    }
}
