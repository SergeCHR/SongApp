package com.command;

import com.audio.collection.SongCollection;
import com.audio.collection.SongCollectionUtils;
import com.handlers.HandleInputError;
import com.helpers.HelperFunctions;
import com.store.Store;

import java.util.Map;

public class CalculateCollectionDuration implements Command{
    public static final String NAME = "calculate_collection_duration";
    public static final String INFO = "calculates certain collection duration";
    public static final String PARAMS = "|params: name";
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
