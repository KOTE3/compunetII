package com.example.repository;

import com.example.model.Track;
import java.util.List;

public interface ITrackRepository {

    Track save(Track track);

    List<Track> findAll();

    Track findById(Integer id);

    void deleteById(Integer id);
}