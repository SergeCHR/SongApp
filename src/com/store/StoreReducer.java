package com.store;

import com.command.*;

import java.util.HashMap;
import java.util.Map;

public class StoreReducer {
    private Store store;
    private Map<String, Command> commands = new HashMap<>();
    public StoreReducer(Store store){
        this.store = store;
        this.commands.put(CreateSong.NAME, new CreateSong(this.store));
        this.commands.put(CreateCollection.NAME, new CreateCollection(this.store));
        this.commands.put(CreateDisk.NAME, new CreateDisk(this.store));
        this.commands.put(Exit.NAME, new Exit());
        this.commands.put(ShowSongs.NAME, new ShowSongs(this.store));
        this.commands.put(ShowCollections.NAME, new ShowCollections(this.store));
        this.commands.put(ShowDisks.NAME, new ShowDisks(this.store));
        this.commands.put(AddSongToCollection.NAME, new AddSongToCollection(this.store));
        this.commands.put(AddCollectionToDisk.NAME, new AddCollectionToDisk(this.store));
        this.commands.put(DeleteSong.NAME, new DeleteSong(this.store));
        this.commands.put(DeleteCollection.NAME, new DeleteCollection(this.store));
        this.commands.put(DeleteDisk.NAME, new DeleteDisk(this.store));
        this.commands.put(DeleteSongFromDisk.NAME, new DeleteSongFromDisk(this.store));
        this.commands.put(DeleteSongFromCollection.NAME, new DeleteSongFromCollection(this.store));
        this.commands.put(WriteStoreToFile.NAME, new WriteStoreToFile(this.store));
        this.commands.put(InitStoreFromFile.NAME, new InitStoreFromFile(this.store));
        this.commands.put(CalculateCollectionDuration.NAME, new CalculateCollectionDuration(this.store));
        this.commands.put(CalculateDiskDuration.NAME, new CalculateDiskDuration(this.store));
        this.commands.put(SortDiskByStyle.NAME, new SortDiskByStyle(this.store));
        this.commands.put(SongsByDurationRange.NAME, new SongsByDurationRange(this.store));
    }

    public Map<String, Command> getCommands() {
        return commands;
    }
}
