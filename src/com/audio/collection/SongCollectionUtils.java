package com.audio.collection;

import com.audio.song.Song;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SongCollectionUtils {
    public Integer calculateDuration(SongCollection collection){
        List<Song> songs = collection.getSongCollection();
        Integer duration = 0;
        for (Song song: songs) {
            duration += song.getDuration();
        }
        return duration;
    }
    public List<SongCollection> readFromFile(String filename){
        List<SongCollection> fileCollections = new ArrayList<SongCollection>();
        try{
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            while(true){
                SongCollection collection = (SongCollection)objIn.readObject();
                if(collection == null) break;
                fileCollections.add(collection);
            objIn.close();
            }

        }
        catch (Exception e){}
        return fileCollections;
    }
    public void writeToFile(String filename, List<SongCollection> collections){

        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);

            for (SongCollection collection: collections) {
                objOut.writeObject(collection);
            }
            objOut.close();
        }

        catch (Exception e) {
        }
    }

}
