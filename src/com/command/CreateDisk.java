package com.command;

import com.audio.disk.Disk;
import com.audio.song.Song;
import com.handlers.HandleInputError;
import com.helpers.HelperFunctions;
import com.store.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class CreateDisk implements Command{
    public static final String NAME = "create_disk";
    public static final String INFO = "creates disk";
    public static final String PARAMS = "|params: name";
    private Store store;
    public CreateDisk(Store store){
        this.store = store;
    }

    @Override
    public void execute(Map<String, String> params) {
        HelperFunctions helperFunctions = new HelperFunctions();
        HandleInputError error = new HandleInputError();
        String diskName = params.get("name");
        if (diskName == null){
            error.handle();
        }
        UUID id = helperFunctions.generateId();
        List<Song> diskSongs = new ArrayList<>();
        Disk disk = new Disk(diskName, diskSongs, id);
        store.getCreatedDisks().add(disk);
    }
}
