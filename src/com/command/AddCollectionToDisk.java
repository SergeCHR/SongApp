package com.command;

import com.audio.collection.SongCollection;
import com.audio.disk.Disk;
import com.handlers.HandleInputError;
import com.helpers.HelperFunctions;
import com.store.Store;

import java.util.Map;

public class AddCollectionToDisk implements Command{
    public static final String NAME = "add_collection_to_dik";
    public static final String INFO = "adds certain collection to certain disk";
    public static final String PARAMS = "|params: diskName collectionName";
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
