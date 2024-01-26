package com.soundapp.components.fileloader;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;

public class Fileloader {
    private Gui gui;
    private ArrayList<String> sounds;

    public Fileloader (){
        sounds = new ArrayList<String>();
        //addSoundToList();
        gui = new Gui(this);
    }

    public Gui getGui(){
        return gui;
    }

    private void addSoundToList(String path){
        sounds.add(path);
        gui.addSoundButton(path);
    }

    protected ArrayList<String> getSounds(){
        return sounds;
    }

    protected void openFileChooser() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);

        int result = fileChooser.showOpenDialog(gui);

        if (result == JFileChooser.APPROVE_OPTION) {
            File[] selectedFiles = fileChooser.getSelectedFiles();

            // Update your array with the selected file paths
            //sounds = new String[selectedFiles.length];
            for (int i = 0; i < selectedFiles.length; i++) {
                 addSoundToList(selectedFiles[i].getAbsolutePath());
            }
            
            gui.updateButtons();
            // Print selected file paths (you can replace this with your desired logic)
            System.out.println("Selected Files:");
            for (String filePath : sounds) {
                System.out.println(filePath);
            }
        }
    }
}
