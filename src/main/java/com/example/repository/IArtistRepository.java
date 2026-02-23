package com.example.repository;

import java.util.List;
import com.example.model.Artist;

public interface IArtistRepository {

    List<Artist> findAll();

    Artist save(Artist artist);

    List<Artist> getArtists();

    boolean delete(Integer id);

    Artist findById(Integer id);

    Artist findByName(String name);
}
