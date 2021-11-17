package com.audio.disk;

import com.audio.collection.SongCollection;
import com.audio.song.Song;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DiskUtils {
    public Integer calculateDuration(Disk disk){
        List<Song> songs = disk.getDisk();
        Integer duration = 0;
        for (Song song: songs) {
            duration += song.getDuration();
        }
        return duration;
    }
    public List<Disk> readFromFile(String filename){
        List<Disk> fileDisks = new ArrayList<Disk>();
        try{
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            while(true){
                Disk disk = (Disk) objIn.readObject();
                if(disk == null) break;
                fileDisks.add(disk);
                objIn.close();
            }

        }
        catch (Exception e){}
        return fileDisks;
    }
    public void writeToFile(String filename, List<Disk> disks){

        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);

            for (Disk disk: disks) {
                objOut.writeObject(disk);
            }
            objOut.close();
        }

        catch (Exception e) {
        }
    }
}
