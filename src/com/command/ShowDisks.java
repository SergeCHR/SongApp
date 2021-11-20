package com.command;

import com.store.Store;

import java.util.Map;

public class ShowDisks implements Command{
    public static final String NAME = "show_disks";
    public static final String INFO = "shows disks created";
    public static final String PARAMS = "|no params needed";
    private Store store;
    public ShowDisks(Store store){
        this.store = store;
    }
    @Override
    public void execute(Map<String, String> params) {
        System.out.println(store.getCreatedDisks());
    }
}
