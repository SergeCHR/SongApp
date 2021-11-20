package com.command;

import com.audio.collection.SongCollection;
import com.handlers.HandleInputError;
import com.helpers.HelperFunctions;
import com.store.Store;

import java.util.Map;

public class DeleteCollection implements Command{
    public static final String NAME = "delete_collection";
    public static final String INFO = "deletes collection from created collections";
    public static final String PARAMS = "|params: name";
    private Store store;
    public DeleteCollection(Store store){
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
        SongCollection collectionToDelete = helperFunctions.findCollection(store.getCreatedCollections(), collectionName);
        if (collectionToDelete == null){
            error.handle();
            return;
        }
        store.getCreatedCollections().remove(collectionToDelete);
    }
}
