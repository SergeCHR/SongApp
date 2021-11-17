package com.store;

import com.audio.collection.SongCollection;
import com.audio.disk.Disk;
import com.audio.song.Song;

import java.util.List;
import java.util.ArrayList;

public class Store {
    private List<Song> createdSongs;
    private List<SongCollection> createdCollection;
    private List<Disk> createdDisks;

    public Store() {
        this.createdSongs = new ArrayList<Song>();
        this.createdCollection = new ArrayList<SongCollection>();
        this.createdDisks = new ArrayList<Disk>();
    }

    public List<Song> getCreatedSongs() {
        return createdSongs;
    }

    public void setCreatedSongs(List<Song> createdSongs) {
        this.createdSongs = createdSongs;
    }

    public List<SongCollection> getCreatedCollections() {
        return createdCollection;
    }

    public void setCreatedCollection(List<SongCollection> createdCollection) {
        this.createdCollection = createdCollection;
    }

    public List<Disk> getCreatedDisks() {
        return createdDisks;
    }

    public void setCreatedDisks(List<Disk> createdDisks) {
        this.createdDisks = createdDisks;
    }
}
