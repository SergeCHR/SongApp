package com.command;


import com.audio.disk.Disk;
import com.handlers.HandleInputError;
import com.helpers.HelperFunctions;
import com.store.Store;

import java.util.Map;

public class DeleteDisk implements Command{
    public static final String NAME = "delete_disk";
    public static final String INFO = "deletes disk from created disks";
    public static final String PARAMS = "|params: name";
    private Store store;
    public DeleteDisk(Store store){
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
        Disk diskToDelete = helperFunctions.findDisk(store.getCreatedDisks(), diskName);
        if (diskToDelete == null){
            error.handle();
            return;
        }
        store.getCreatedDisks().remove(diskToDelete);
    }
}
