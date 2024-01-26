package com.soundapp.components.fileloader;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Gui extends JPanel{
    private Fileloader parent;
    private ArrayList<JButton> buttons;
    private JPanel buttonPanel;

    public Gui(Fileloader parent){
        this.parent = parent;
        buttons = new ArrayList<JButton>();

        setLayout(new FlowLayout());
        Border redline = BorderFactory.createLineBorder(Color.BLACK);
        setBorder(redline);
        fileChooserButton();
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0,2));
        add(buttonPanel);
        
    }

    protected void fileChooserButton(){
        JButton button = new JButton("Selecteer bestanden:");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                parent.openFileChooser();
            }
        });
        button.setBounds(10, 0, 100, 20);
        add(button);
    }

    protected void addSoundButton(String uri){
        JButton button = new JButton(uri);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println(e);
                //parent.loadSound();
            }
        });
        buttons.add(button);
    }

    protected void updateButtons(){
        int index = 1;
        for (JButton jButton : buttons) {
            //jButton.setBounds(5, 5, 80, 80);
            System.out.println(jButton);
            buttonPanel.add(jButton);
            index++;
        }
        System.out.println(buttonPanel);
        revalidate();
        repaint();
    }

}
