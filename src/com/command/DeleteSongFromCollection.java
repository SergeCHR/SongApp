package com.command;

import com.audio.collection.SongCollection;
import com.audio.disk.Disk;
import com.audio.song.Song;
import com.handlers.HandleInputError;
import com.helpers.HelperFunctions;
import com.store.Store;

import java.util.List;
import java.util.Map;

public class DeleteSongFromCollection implements Command{
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
