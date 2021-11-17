package com.command;

import com.audio.song.Song;
import com.handlers.HandleInputError;
import com.helpers.HelperFunctions;
import com.store.Store;

import java.util.List;
import java.util.Map;

public class DeleteSong implements Command{
    private Store store;
    public DeleteSong(Store store){
        this.store = store;
    }
    @Override
    public void execute(Map<String, String> params) {
        String songName = params.get("name");
        HandleInputError error = new HandleInputError();
        if (songName == null){
            error.handle();
            return;
        }
        HelperFunctions helperFunctions = new HelperFunctions();
        Song songToDelete = helperFunctions.findSong(store.getCreatedSongs(), songName);
        if (songToDelete == null){
            error.handle();
            return;
        }
        store.getCreatedSongs().remove(songToDelete);
    }
}
