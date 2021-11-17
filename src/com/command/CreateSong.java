package com.command;

import com.audio.song.Song;
import com.handlers.HandleInputError;
import com.helpers.HelperFunctions;
import com.store.Store;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class CreateSong implements Command{
    private Store store;
    public CreateSong(Store store){
        this.store = store;
    }
    HelperFunctions helperFunctions = new HelperFunctions();
    @Override
    public void execute(Map<String, String> params) {
        UUID id = helperFunctions.generateId();
        String songName = params.get("name");
        String songStyle = params.get("style");
        HandleInputError error = new HandleInputError();
        Integer duration;
        try {
            duration = Integer.parseInt(params.get("duration"));
        }
        catch (NumberFormatException e){
            System.out.println("Duration cannot be parsed into number. Please try again...");
            return;
        }
        if(songName == null || songStyle == null || duration == null){
            error.handle();
            return;
        }

        Song song = new Song(songName, songStyle, duration, id);
        store.getCreatedSongs().add(song);

    }
}
