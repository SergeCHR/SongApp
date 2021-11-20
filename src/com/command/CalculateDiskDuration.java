package com.command;

import com.audio.collection.SongCollection;
import com.audio.collection.SongCollectionUtils;
import com.audio.disk.Disk;
import com.audio.disk.DiskUtils;
import com.handlers.HandleInputError;
import com.helpers.HelperFunctions;
import com.store.Store;

import java.util.Map;

public class CalculateDiskDuration implements Command{
    public static final String NAME = "calculate_disk_duration";
    public static final String INFO = "calculates certain disk duration";
    public static final String PARAMS = "|params: name";
    private Store store;
    public CalculateDiskDuration(Store store){
        this.store = store;
    }
    @Override
    public void execute(Map<String, String> params) {
        String diskName = params.get("name");
        HandleInputError error = new HandleInputError();
        if (diskName == null){
            error.handle();
            return;
        }
        HelperFunctions helperFunctions = new HelperFunctions();
        Disk disk = helperFunctions.findDisk(store.getCreatedDisks(), diskName);
        if (disk == null){
            error.handle();
            return;
        }
        DiskUtils diskUtils = new DiskUtils();
        Integer duration = diskUtils.calculateDuration(disk);
        System.out.println(diskName + " duration: " + duration);
    }
}
