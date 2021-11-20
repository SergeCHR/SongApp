package com.command;

import com.audio.collection.SongCollection;
import com.audio.song.Song;
import com.handlers.HandleInputError;
import com.helpers.HelperFunctions;
import com.store.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class CreateCollection implements Command{
    public static final String NAME = "create_collection";
    public static final String INFO = "creates collection";
    public static final String PARAMS = "|params: name";
    private Store store;
    public CreateCollection(Store store){
        this.store = store;
    }

    @Override
    public void execute(Map<String, String> params) {
        HelperFunctions helperFunctions = new HelperFunctions();
        String collectionName = params.get("name");
        HandleInputError error = new HandleInputError();
        if (collectionName == null){
            error.handle();
            return;
        }
        UUID id = helperFunctions.generateId();
        List<Song> collectionSongs = new ArrayList<>();
        SongCollection collection = new SongCollection(collectionName, collectionSongs, id);
        store.getCreatedCollections().add(collection);
    }
}
