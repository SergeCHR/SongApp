package com.command;

import com.audio.song.Song;
import com.store.Store;

import java.util.List;
import java.util.Map;

public class ShowSongs implements Command{
    private Store store;
    public ShowSongs(Store store){
        this.store = store;
    }
    @Override
    public void execute(Map<String, String> params) {
        System.out.println(store.getCreatedSongs());
    }
}
