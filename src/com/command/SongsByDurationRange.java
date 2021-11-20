package com.command;

import com.audio.disk.Disk;
import com.audio.song.Song;
import com.handlers.HandleInputError;
import com.helpers.HelperFunctions;
import com.store.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SongsByDurationRange implements Command{
    Store store;
    public SongsByDurationRange(Store store){
        this.store = store;
    }
    @Override
    public void execute(Map<String, String> params) {
        String diskName = params.get("diskName");
        Integer rangeStart, rangeEnd;
        HandleInputError error = new HandleInputError();
        if (diskName == null){
            error.handle();
        }
        try {
            rangeStart = Integer.parseInt(params.get("rangeStart"));
            rangeEnd = Integer.parseInt(params.get("rangeEnd"));
        }
        catch (NumberFormatException e){
            System.out.println("range cannot be parsed into number. Please try again...");
            return;
        }
        HelperFunctions helperFunctions = new HelperFunctions();
        List<Song> songsInRange = new ArrayList<Song>();
        Disk disk = helperFunctions.findDisk(store.getCreatedDisks(), diskName);
        List<Song> diskSongs = disk.getDisk();
        for (Song diskSong: diskSongs) {
            if(helperFunctions.songInRange(rangeStart, rangeEnd, diskSong)){
                songsInRange.add(diskSong);
            }
        }
        System.out.println("Songs in range:");
        System.out.println(songsInRange);
    }
}
