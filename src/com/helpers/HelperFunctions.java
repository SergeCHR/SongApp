package com.helpers;

import com.audio.collection.SongCollection;
import com.audio.disk.Disk;
import com.audio.song.Song;

import java.util.List;
import java.util.UUID;

public class HelperFunctions {
    public UUID generateId() {
        UUID uniqueKey = UUID.randomUUID();
        return uniqueKey;
    }
    public Song findSong(List<Song> songs, String songName){
        for (Song song: songs) {
            if (song.getName().equals(songName)) return song;
        }
        return  null;
    }
    public SongCollection findCollection(List<SongCollection> collections, String collectionName){
        for (SongCollection collection: collections) {
            if (collection.getName().equals(collectionName)) return collection;
        }
        return  null;
    }
    public Disk findDisk(List<Disk> disks, String diskName){
        for (Disk disk: disks) {
            if (disk.getName().equals(diskName)) return disk;
        }
        return  null;
    }
}
