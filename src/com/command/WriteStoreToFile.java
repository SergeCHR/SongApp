package com.command;

import com.audio.collection.SongCollectionUtils;
import com.audio.disk.DiskUtils;
import com.audio.song.SongUtils;
import com.store.Store;

import java.util.Map;

public class WriteStoreToFile implements Command{
   private Store store;
    public WriteStoreToFile(Store store){
        this.store = store;
    }
    @Override
    public void execute(Map<String, String> params) {
        SongUtils songUtils = new SongUtils();
        SongCollectionUtils songCollectionUtils = new SongCollectionUtils();
        DiskUtils diskUtils = new DiskUtils();
        songUtils.writeToFile("Songs.txt", store.getCreatedSongs());
        songCollectionUtils.writeToFile("Collections.txt", store.getCreatedCollections());
        diskUtils.writeToFile("Disks.txt", store.getCreatedDisks());
    }
}
