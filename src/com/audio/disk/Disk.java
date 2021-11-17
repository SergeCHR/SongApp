package com.audio.disk;

import com.audio.song.Song;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class Disk implements Serializable {
    private String name;
    private List<Song> disk;
    private UUID id;

    public Disk(String name, List<Song> disk, UUID id) {
        this.name = name;
        this.disk = disk;
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getDisk() {
        return disk;
    }

    public void setDisk(List<Song> disk) {
        this.disk = disk;
    }

    @Override
    public String toString() {
        return "Disk{" +
                "name='" + name + '\'' +
                ", disk=" + disk +
                ", id=" + id +
                '}';
    }
}
