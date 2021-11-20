package com.command;

import com.audio.collection.SongCollection;
import com.store.Store;

import java.util.List;
import java.util.Map;

public class ShowCollections implements Command{
    public static final String NAME = "show_collections";
    public static final String INFO = "shows collections created";
    public static final String PARAMS = "|no params needed";
    private Store store;
    public ShowCollections(Store store){
        this.store = store;
    }
    @Override
    public void execute(Map<String, String> params) {
        List<SongCollection> collectionList = store.getCreatedCollections();
        if (collectionList.isEmpty())
            System.out.println("No collections were created");
        else
            System.out.println(collectionList);
    }
}
