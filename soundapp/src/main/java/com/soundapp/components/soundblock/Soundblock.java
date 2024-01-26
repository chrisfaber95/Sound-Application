package com.soundapp.components.soundblock;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Soundblock {

    private String filePath;
    private String type;
    private Boolean autostart;
    private Long currentFrame;
    private Clip clip;
    private AudioInputStream audioInputStream;
    private String status;

    private Gui gui;

    private Timer t;
    
    public Soundblock(){
        filePath = "";
        type = "wav";
        gui = new Gui(this);
        autostart = false;
        currentFrame = (long) 0;
    }

    protected void playSound(){
        if(currentFrame != 0) {
            clip.setMicrosecondPosition(currentFrame);
        }
       
        clip.start();
        status = "play";
        t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                long location = clip.getMicrosecondPosition();
                long length = clip.getMicrosecondLength();
                int percentage = (int) (0.5d + ((double)location/(double)length) * 100);
                gui.updateTimeline(percentage);
                if(location == length){
                    gui.updateTimeline(0);
                    t.cancel();
                }
            }
        }, 1000, 500);
    }

    protected void loadSound(){
        try {
            audioInputStream = AudioSystem.getAudioInputStream(
                    new File(filePath).getAbsoluteFile()); 
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            if(gui.getTimeline().get_x_location() != 0){
                float location = gui.getTimeline().get_x_location();
                float length = gui.getTimeline().getWidth();
                updateTime(location/length);
            }
            if(autostart == true){
                playSound();
            }
        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        }

    }

    protected void pauseSound(){
        if(status == "play"){
            currentFrame = clip.getMicrosecondPosition();
            clip.stop();
            status = "paused";
        }
        else if(status == "paused"){
            clip.setMicrosecondPosition(currentFrame);
            playSound();
        }
        else{
            
        }

    }

    protected void restartSound(){
        clip.close();
        loadSound();
    }

    protected void stopSound(){
        clip.close();
    }

    public Gui getGui(){
        return gui;
    }

    public void updateTime(float time){
    //    System.out.println(time);
        if(clip != null){
            long length = clip.getMicrosecondLength();
            float updateFrame = length * time;
      //      System.out.println(updateFrame);
      //      System.out.println((long)updateFrame);
            currentFrame = (long) updateFrame;
            System.out.println(currentFrame);
        }
    }
}
