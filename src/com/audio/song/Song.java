package com.audio.song;

import java.io.Serializable;
import java.util.UUID;


public class Song implements Serializable {
    private String name;
    private String style;
    private Integer duration;
    private UUID id;


    public Song(Object name, Object style, Object duration, UUID id) {
        this.name = (String)name;
        this.style = (String)style;
        this.duration = (Integer)duration;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", style='" + style + '\'' +
                ", duration=" + duration +
                ", id=" + id +
                '}';
    }
}
