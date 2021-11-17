package com.command;

import com.audio.collection.SongCollection;
import com.audio.song.Song;
import com.handlers.HandleInputError;
import com.helpers.HelperFunctions;
import com.store.Store;

import java.util.List;
import java.util.Map;

public class AddSongToCollection implements Command{
    private Store store;
    public AddSongToCollection(Store store){
        this.store = store;
    }
    @Override
    public void execute(Map<String, String> params) {
        String songName = params.get("songName");
        String collectionName = params.get("collectionName");
        HandleInputError error = new HandleInputError();
        if (songName == null || collectionName == null){
            error.handle();
            return;
        }
        HelperFunctions helperFunctions = new HelperFunctions();
        Song song = helperFunctions.findSong(store.getCreatedSongs(), songName);
        SongCollection collection = helperFunctions.findCollection(store.getCreatedCollections(), collectionName);
        if (song==null || collection==null){
            error.handle();
            return;
        }
        collection.getSongCollection().add(song);
    }
}
