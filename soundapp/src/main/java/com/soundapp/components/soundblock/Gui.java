package com.soundapp.components.soundblock;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;

import javax.swing.border.Border;


import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

public class Gui extends JPanel {
    private JButton button;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private Timeline timeline;
    private Soundblock parent;
    private MouseListener ml;
    

    public Gui(Soundblock parent){
        this.parent = parent;
        
        setLayout(new BorderLayout());

        Border redline = BorderFactory.createLineBorder(Color.red);
        setBorder(redline);

        JLabel label = new JLabel("testlabel");
        add(label, BorderLayout.NORTH);

        add(setButtonPanel(), BorderLayout.CENTER);
        
        timeline = new Timeline(0);
        timeline.setBounds(10, 60, 200, 20);
        add(timeline, BorderLayout.SOUTH);
        setMouseListener();
        timeline.addMouseListener(ml);
    }

    private JPanel setButtonPanel(){
        JPanel playbackButtons = new JPanel();
        playbackButtons.setLayout(new BoxLayout(playbackButtons, 2));
        playbackButtons.add(setLoadButton());
        playbackButtons.add(setStartButton());
        playbackButtons.add(setPauseButton());
        playbackButtons.add(setStopButton());
        return playbackButtons;
    }

    public JButton getButton(){
        return button;
    }

    public Timeline getTimeline(){
        return timeline;
    }

    protected void updateTimeline(int percentage){
        int location = Math.round(timeline.getWidth() / 100 * percentage);
        timeline.updateMarkerLocation(location);
    }

    private JButton setLoadButton(){
        JButton button = new JButton("Load");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
               // System.out.println(e);
                parent.loadSound();
            }
        });
        return button;
    }
    private JButton setStartButton(){
        JButton button = new JButton("Play");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
               // System.out.println(e);
                parent.playSound();
            }
        });

        return button;
    }
    private JButton setPauseButton(){
        JButton button = new JButton("Pause");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println(e);
                parent.pauseSound();
            }
        });
        return button;
    }
    private JButton setStopButton(){
        JButton button = new JButton("Stop");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println(e);
                parent.stopSound();
            }
        });
        return button;
    }



    private void setMouseListener(){
        final int S = 6;
        Rectangle sensor = new Rectangle(S,S);
        ml = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                try {
                    timeline.updateMarkerLocation(e.getX());
                    float location =  e.getX();
                    float length =  timeline.getWidth();
                    parent.updateTime(location/length);
                } catch (Exception e1) {
                    System.out.println(e1);
                    throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
            
                }
                }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
            
                try {
                    
            //        System.out.println(e);
                } catch (Exception e1) {
                    System.out.println(e1);
                    throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
            
                }}

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
            
                try {
                    
            //        System.out.println(e);
                } catch (Exception e1) {
                    System.out.println(e1);
                    throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
            
                }}

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
            
                try {
                    
            //        System.out.println(e);
                } catch (Exception e1) {
                    System.out.println(e1);
                    throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
            
                }}

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
           
                try {
                    
          //          System.out.println(e);
                } catch (Exception e1) {
                    System.out.println(e1);
                    throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
            
                }}
        };
    }
}
