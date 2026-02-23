package com.example.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Artist;
import org.springframework.stereotype.Repository;
import com.example.repository.IArtistRepository;

@Repository
public class ArtistRepository implements IArtistRepository {

    private List<Artist> artists = new ArrayList<>();
    private Integer nextId = 1;

    public List<Artist> findAll() {
        return new ArrayList<>(artists);
    }

    public Artist save(Artist artist) {
        if (artist == null) {
            return null;
        }

        if (artist.getId() == null) {
            artist.setId(nextId++);
            artists.add(artist);
            return artist;
        }

        for (int i = 0; i < artists.size(); i++) {
            if (artist.getId().equals(artists.get(i).getId())) {
                artists.set(i, artist);
                return artist;
            }
        }

        artists.add(artist);
        return artist;
    }

    public List<Artist> getArtists() {
        return new ArrayList<>(artists);
    }

    public Artist findById(Integer id) {
        if (id == null)
            return null;

        for (Artist artist : artists) {
            if (id.equals(artist.getId())) {
                return artist;
            }
        }
        return null;
    }

    public Artist findByName(String name) {
        if (name == null)
            return null;

        for (Artist artist : artists) {
            if (name.equalsIgnoreCase(artist.getName())) {
                return artist;
            }
        }
        return null;
    }

    public boolean delete(Integer id) {
        if (id == null)
            return false;

        for (int i = 0; i < artists.size(); i++) {
            if (id.equals(artists.get(i).getId())) {
                artists.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean existsByName(String name) {
        if (name == null)
            return false;

        for (Artist artist : artists) {
            if (name.equalsIgnoreCase(artist.getName())) {
                return true;
            }
        }
        return false;
    }
}