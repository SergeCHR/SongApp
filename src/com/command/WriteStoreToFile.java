package com.command;

import com.audio.collection.SongCollectionUtils;
import com.audio.disk.DiskUtils;
import com.audio.song.SongUtils;
import com.store.Store;

import java.util.Map;

public class WriteStoreToFile implements Command{
    public static final String NAME = "write_store";
    public static final String INFO = "writes store to file";
    public static final String PARAMS = "|no params needed";
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
