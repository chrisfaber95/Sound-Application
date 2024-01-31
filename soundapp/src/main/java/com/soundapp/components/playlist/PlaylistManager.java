package com.soundapp.components.playlist;

import java.io.File;
import java.util.ArrayList;

public class PlaylistManager {
    private ArrayList<File> playlist;
    private Gui gui;

    public PlaylistManager(){
        playlist = new ArrayList<File>();
        gui = new Gui(this);
    }

    public void addToPlaylist(File url){
        playlist.add(url);
        System.out.println(url);
        gui.addToPlaylist(playlist.size(), url.getName());
    }

    public void removeFromPlaylist(File url){
        playlist.remove(url);
        gui.reloadPlaylist();
    }

    public void removeIndexFromPlaylist(int index){
        playlist.remove(index);
        gui.reloadPlaylist();
    }

    public ArrayList<File> getPlaylist(){
        return playlist;
    }

    protected void clearPlaylist(){
        playlist.clear();
    }

    //TODO: Add function for saving playlist.
    protected void reloadPlaylist(){

    }

    public Gui getGui(){
        return this.gui;
    }

}
