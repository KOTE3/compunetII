package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class Artist {
    private Integer id;
    private String name;
    private String nationality;
    private List<Track> tracks = new ArrayList<>(); // importante inicializar la lista para evitar NullPointerException

    public Artist(Integer id, String name, String nationality, List<Track> tracks) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.tracks = tracks;
    }

    public Artist() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNationality() {
        return nationality;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public List<Track> getTracks() {
        return tracks;
    }

}
