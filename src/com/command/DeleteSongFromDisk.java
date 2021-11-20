package com.command;

import com.audio.disk.Disk;
import com.audio.song.Song;
import com.handlers.HandleInputError;
import com.helpers.HelperFunctions;
import com.store.Store;

import java.util.Map;

public class DeleteSongFromDisk implements Command{
    public static final String NAME = "delete_song_from_disk";
    public static final String INFO = "deletes song from certain disk";
    public static final String PARAMS = "|params: songName diskName";
    private Store store;
    public DeleteSongFromDisk(Store store){
        this.store = store;
    }

    @Override
    public void execute(Map<String, String> params) {
        String diskName = params.get("diskName");
        String songName = params.get("songName");
        HandleInputError error = new HandleInputError();
        if (diskName == null || songName == null){
            error.handle();
            return;
        }
        HelperFunctions helperFunctions = new HelperFunctions();
        Disk disk = helperFunctions.findDisk(store.getCreatedDisks(), diskName);
        Song songToDelete = helperFunctions.findSong(store.getCreatedSongs(), songName);
        if (disk == null || songToDelete == null){
            error.handle();
            return;
        }
        disk.getDisk().remove(songToDelete);
    }
}
