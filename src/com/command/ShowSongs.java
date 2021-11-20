package com.command;

import com.store.Store;

import java.util.Map;

public class ShowSongs implements Command{
    public static final String NAME = "show_songs";
    public static final String INFO = "shows songs created";
    public static final String PARAMS = "|no params needed";
    private Store store;
    public ShowSongs(Store store){
        this.store = store;
    }
    @Override
    public void execute(Map<String, String> params) {
        System.out.println(store.getCreatedSongs());
    }
}
