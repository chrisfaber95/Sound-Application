package com.soundapp.components.fileloader;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.soundapp.components.soundfile.SoundFile;

public class Gui extends JPanel{
    private Fileloader parent;
    private ArrayList<JButton> buttons;
    private JPanel buttonPanel;

    public Gui(Fileloader parent){
        this.parent = parent;
        buttons = new ArrayList<JButton>();

        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        Border blackline = BorderFactory.createLineBorder(Color.BLACK);
        setBorder(blackline);
        fileChooserButton();
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0,2, 10, 5));
        add(buttonPanel);
        
    }

    //Setup button to select files
    protected void fileChooserButton(){
        JButton button = new JButton("Selecteer bestanden:");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                parent.openFileChooser();
            }
        });
        button.setPreferredSize(new Dimension(200, 20));
        //button.setBounds();
        add(button);
    }

    //Setup button to load music file in player stack
    protected void addSoundButton(File url){
        final File final_url = url;
        JButton button = new JButton(final_url.getName());
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                parent.addToPlaylist(final_url);
            }
        });
        button.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        button.setPreferredSize(new Dimension(this.getWidth()/2-10, 20));
        //button.setSize(50, 20);
        buttons.add(button);
    }

    // Update the list of sound buttons
    protected void updateButtons(){
        int index = 1;
        for (JButton jButton : buttons) {
            buttonPanel.add(jButton);
            index++;
        }
        System.out.println(buttonPanel);
        revalidate();
        repaint();
    }

}
