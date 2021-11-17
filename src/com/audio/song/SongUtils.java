package com.audio.song;

import com.audio.disk.Disk;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SongUtils {
    public List<Song> readFromFile(String filename){
        List<Song> fileSongs = new ArrayList<Song>();
        try{
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            while(true){
                Song song = (Song) objIn.readObject();
                if(song == null) break;
                fileSongs.add(song);
                objIn.close();
            }

        }
        catch (Exception e){}
        return fileSongs;
    }
    public void writeToFile(String filename, List<Song> songs){
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);

            for (Song song: songs) {
                objOut.writeObject(song);
            }
            objOut.close();
        }

        catch (Exception e) {
        }
    }
}
