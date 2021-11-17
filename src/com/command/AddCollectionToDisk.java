package com.command;

import com.audio.collection.SongCollection;
import com.audio.disk.Disk;
import com.audio.song.Song;
import com.handlers.HandleInputError;
import com.helpers.HelperFunctions;
import com.store.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddCollectionToDisk implements Command{
    private Store store;
    public AddCollectionToDisk(Store store){
        this.store = store;
    }
    @Override
    public void execute(Map<String, String> params) {
        String diskName = params.get("diskName");
        String collectionName = params.get("collectionName");
        HandleInputError error = new HandleInputError();
        if (diskName == null || collectionName == null){
            error.handle();
            return;
        }
        HelperFunctions helperFunctions = new HelperFunctions();
        Disk disk = helperFunctions.findDisk(store.getCreatedDisks(), diskName);
        SongCollection collection = helperFunctions.findCollection(store.getCreatedCollections(), collectionName);
        if (disk == null || collection == null){
            error.handle();
            return;
        }
        disk.getDisk().addAll(collection.getSongCollection());
    }
}
