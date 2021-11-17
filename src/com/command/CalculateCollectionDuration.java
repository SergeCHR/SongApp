package com.command;

import com.audio.collection.SongCollection;
import com.audio.collection.SongCollectionUtils;
import com.handlers.HandleInputError;
import com.helpers.HelperFunctions;
import com.store.Store;

import java.util.List;
import java.util.Map;

public class CalculateCollectionDuration implements Command{
    private Store store;
    public CalculateCollectionDuration(Store store){
        this.store = store;
    }
    @Override
    public void execute(Map<String, String> params) {
        String collectionName = params.get("name");
        HandleInputError error = new HandleInputError();
        if (collectionName == null){
            error.handle();
            return;
        }
        HelperFunctions helperFunctions = new HelperFunctions();
        SongCollection collection = helperFunctions.findCollection(store.getCreatedCollections(), collectionName);
        if (collection == null){
            error.handle();
            return;
        }
        SongCollectionUtils songCollectionUtils = new SongCollectionUtils();
        Integer duration = songCollectionUtils.calculateDuration(collection);
        System.out.println(collectionName + " duration: " + duration);
    }
}
