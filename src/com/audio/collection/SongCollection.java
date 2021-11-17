package com.audio.collection;

import com.audio.song.Song;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class SongCollection implements Serializable {
    private String name;
    private List<Song> songCollection;
    private UUID id;

    public SongCollection(String name, List<Song> songCollection, UUID id) {
        this.name = name;
        this.songCollection = songCollection;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongCollection() {
        return songCollection;
    }

    public void setSongCollection(List<Song> songCollection) {
        this.songCollection = songCollection;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "SongCollection{" +
                "name='" + name + '\'' +
                ", songCollection=" + songCollection +
                ", id=" + id +
                '}';
    }
}
