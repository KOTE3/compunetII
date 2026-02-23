package com.example.service;

import java.util.List;

import com.example.model.Artist;
import com.example.repository.impl.ArtistRepository;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {

    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public void createArtist(String name, String nationality) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is required");
        }

        if (nationality == null || nationality.isBlank()) {
            throw new IllegalArgumentException("Nationality is required");
        }

        if (artistRepository.existsByName(name)) {
            throw new IllegalArgumentException("Artist already exists");
        }

        Artist artist = new Artist();
        artist.setName(name.trim());
        artist.setNationality(nationality.trim());

        artistRepository.save(artist);
    }

    public List<Artist> findAll() {
        return artistRepository.findAll();
    }

    public Artist findById(Integer id) {
        return artistRepository.findById(id);
    }

    public Artist findByName(String name) {
        return artistRepository.findByName(name);
    }

    public boolean delete(Integer id) {
        return artistRepository.delete(id);
    }
}