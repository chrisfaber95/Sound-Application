package com.soundapp.components.soundfile;

import java.io.File;

public class SoundFile{
    
    private File file;

    public SoundFile(File file){
        this.file = file;
    }

    public File getFile(){
        return file;
    }
}
