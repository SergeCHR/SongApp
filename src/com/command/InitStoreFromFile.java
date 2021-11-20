package com.command;

import com.audio.collection.SongCollectionUtils;
import com.audio.disk.DiskUtils;
import com.audio.song.SongUtils;
import com.store.Store;

import java.util.Map;

public class InitStoreFromFile implements Command{
    private Store store;
    public InitStoreFromFile(Store store){
       this.store = store;
    }
    @Override
    public void execute(Map<String, String> params) {
        SongUtils songUtils = new SongUtils();
        SongCollectionUtils songCollectionUtils = new SongCollectionUtils();
        DiskUtils diskUtils = new DiskUtils();
        store.setCreatedSongs(songUtils.readFromFile("Songs.txt"));
        store.setCreatedCollection(songCollectionUtils.readFromFile("Collections.txt"));
        store.setCreatedDisks(diskUtils.readFromFile("Disks.txt"));
    }
}
