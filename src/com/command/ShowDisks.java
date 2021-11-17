package com.command;

import com.audio.disk.Disk;
import com.store.Store;

import java.util.List;
import java.util.Map;

public class ShowDisks implements Command{
    private Store store;
    public ShowDisks(Store store){
        this.store = store;
    }
    @Override
    public void execute(Map<String, String> params) {
        System.out.println(store.getCreatedDisks());
    }
}
