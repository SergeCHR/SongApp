package com.command;

import com.audio.disk.Disk;
import com.handlers.HandleInputError;
import com.helpers.HelperFunctions;
import com.store.Store;

import java.util.Collections;
import java.util.Map;

public class SortDiskByStyle implements Command{
    private Store store;
    public SortDiskByStyle(Store store){
        this.store = store;
    }
    @Override
    public void execute(Map<String, String> params) {
        String diskName = params.get("name");
        String style = params.get("style");
        HandleInputError error = new HandleInputError();
        if (diskName == null || style == null){
            error.handle();
        }
        HelperFunctions helperFunctions = new HelperFunctions();
        Disk disk = helperFunctions.findDisk(store.getCreatedDisks(), diskName);

        Collections.sort(disk.getDisk(), (lhs, rhs) -> lhs.getStyle().equals(rhs.getStyle()) ? 0 : -1);
    }
}
