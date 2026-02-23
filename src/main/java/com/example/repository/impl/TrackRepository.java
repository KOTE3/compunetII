package com.example.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Track;
import com.example.repository.ITrackRepository;

import org.springframework.stereotype.Repository;

@Repository
public class TrackRepository implements ITrackRepository {

    private List<Track> tracks = new ArrayList<>();
    private Integer nextId = 1;

    public Track save(Track track) {
        if (track == null)
            return null;

        if (track.getId() == null) {
            track.setId(nextId++);
        } else {
            // Update nextId if needed to avoid collisions
            if (track.getId() >= nextId) {
                nextId = track.getId() + 1;
            }
            // Check if already exists (update)
            for (int i = 0; i < tracks.size(); i++) {
                if (track.getId().equals(tracks.get(i).getId())) {
                    tracks.set(i, track);
                    return track;
                }
            }
        }

        tracks.add(track);
        return track;
    }

    public List<Track> findAll() {
        return new ArrayList<>(tracks);
    }

    public Track findById(Integer id) {
        return tracks.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void deleteById(Integer id) {
        tracks.removeIf(t -> t.getId().equals(id));
    }
}