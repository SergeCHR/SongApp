package com.command;

import com.audio.collection.SongCollection;
import com.audio.song.Song;
import com.handlers.HandleInputError;
import com.helpers.HelperFunctions;
import com.store.Store;


import java.util.Map;

public class DeleteSongFromCollection implements Command{
    public static final String NAME = "delete_song_from_collection";
    public static final String INFO = "deletes song from certain collection";
    public static final String PARAMS = "|params: songName collectionName";
    private Store store;
    public DeleteSongFromCollection(Store store){
        this.store = store;
    }

    @Override
    public void execute(Map<String, String> params) {
        String collectionName = params.get("collectionName");
        String songName = params.get("songName");
        HandleInputError error = new HandleInputError();
        if (collectionName == null || songName == null){
            error.handle();
            return;
        }
        HelperFunctions helperFunctions = new HelperFunctions();
        SongCollection collection = helperFunctions.findCollection(store.getCreatedCollections(), collectionName);
        Song songToDelete = helperFunctions.findSong(store.getCreatedSongs(), songName);
        if (collection == null || songToDelete == null){
            error.handle();
            return;
        }
       collection.getSongCollection().remove(songToDelete);
    }
}
