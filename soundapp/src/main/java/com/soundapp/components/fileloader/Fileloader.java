package com.soundapp.components.fileloader;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.soundapp.components.playlist.PlaylistManager;
import com.soundapp.components.soundfile.SoundFile;

public class Fileloader {
    private Gui gui;
    private ArrayList<File> sounds = new ArrayList<File>();
    private PlaylistManager playlist;

    public Fileloader (PlaylistManager playlist){
        //addSoundToList();
        gui = new Gui(this);
        this.playlist = playlist;
    }

    public Gui getGui(){
        return gui;
    }

    private void addSoundToList(File file){
        sounds.add(file);
        gui.addSoundButton(file);
    }

    protected ArrayList<File> getSounds(){
        return sounds;
    }

    protected void openFileChooser() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "Wav files only", "wav"
        );
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(gui);

        if (result == JFileChooser.APPROVE_OPTION) {
            File[] selectedFiles = fileChooser.getSelectedFiles();

            for (int i = 0; i < selectedFiles.length; i++) {
                 addSoundToList(selectedFiles[i]);
            }
            gui.updateButtons();
        }
    }

    protected void addToPlaylist(File url){
        playlist.addToPlaylist(url);
    }
}
