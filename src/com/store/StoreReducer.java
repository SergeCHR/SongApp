package com.store;

import com.command.*;
import com.constants.Constants;

import java.util.HashMap;
import java.util.Map;

public class StoreReducer {
    private Store store;
    private Map<String, Command> commands = new HashMap<>();
    public StoreReducer(Store store){
        this.store = store;
        this.commands.put(Constants.CREATE_SONG, new CreateSong(this.store));
        this.commands.put(Constants.CREATE_COLLECTION, new CreateCollection(this.store));
        this.commands.put(Constants.CREATE_DISK, new CreateDisk(this.store));
        this.commands.put(Constants.EXIT, new Exit());
        this.commands.put(Constants.SHOW_SONGS, new ShowSongs(this.store));
        this.commands.put(Constants.SHOW_COLLECTIONS, new ShowCollections(this.store));
        this.commands.put(Constants.SHOW_DISKS, new ShowDisks(this.store));
        this.commands.put(Constants.SONG_TO_COLLECTION, new AddSongToCollection(this.store));
        this.commands.put(Constants.COLLECTION_TO_DISK, new AddCollectionToDisk(this.store));
        this.commands.put(Constants.DELETE_SONG, new DeleteSong(this.store));
        this.commands.put(Constants.DELETE_COLLECTION, new DeleteCollection(this.store));
        this.commands.put(Constants.DELETE_DISK, new DeleteDisk(this.store));
        this.commands.put(Constants.DELETE_SONG_FROM_DISK, new DeleteSongFromDisk(this.store));
        this.commands.put(Constants.DELETE_SONG_FROM_COLLECTION, new DeleteSongFromCollection(this.store));
        this.commands.put(Constants.WRITE_STORE, new WriteStoreToFile(this.store));
        this.commands.put(Constants.INIT_STORE, new InitStoreFromFile(this.store));
        this.commands.put(Constants.CALCULATE_COLLECTION_DURATION, new CalculateCollectionDuration(this.store));
        this.commands.put(Constants.CALCULATE_DISK_DURATION, new CalculateDiskDuration(this.store));
        this.commands.put(Constants.SORT_DISK_BY_STYLE, new SortDiskByStyle(this.store));
        this.commands.put(Constants.SONGS_BY_DURATION_RANGE, new SongsByDurationRange(this.store));
    }

    public Map<String, Command> getCommands() {
        return commands;
    }
}
