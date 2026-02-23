package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class Track {
    private Integer id;
    private String title;
    private String genre;
    private double duration;
    private String albumTitle;
    private List<Artist> artists = new ArrayList<>(); // importante inicializar la lista para evitar
                                                      // NullPointerException

    public Track(Integer id, String title, String genre, double duration, String albumTitle,
            List<Artist> artists) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.albumTitle = albumTitle;
        this.artists = artists;
    }

    public Track() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getDuration() {
        return duration;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public List<Artist> getArtists() {
        return artists;
    }
}
