package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Artist;
import com.example.model.Track;
import com.example.repository.impl.TrackRepository;

@Service
public class TrackService {

    private final TrackRepository trackRepository;
    private final ArtistService artistService;

    @Autowired
    public TrackService(TrackRepository trackRepository, ArtistService artistService) {
        this.trackRepository = trackRepository;
        this.artistService = artistService;
    }

    public void addTrack(String title,
            String genre,
            String durationStr,
            String album,
            String[] artistIdsArray) {

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title is required");
        }

        if (genre == null || genre.isBlank()) {
            throw new IllegalArgumentException("Genre is required");
        }

        if (album == null || album.isBlank()) {
            throw new IllegalArgumentException("Album is required");
        }

        double duration;
        try {
            duration = Double.parseDouble(durationStr);
            if (duration <= 0) {
                throw new IllegalArgumentException("Duration must be positive");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid duration format");
        }

        Track track = new Track();
        track.setTitle(title.trim());
        track.setGenre(genre.trim());
        track.setDuration(duration);
        track.setAlbumTitle(album.trim());

        if (artistIdsArray != null) {
            for (String idStr : artistIdsArray) {
                try {
                    Integer id = Integer.parseInt(idStr.trim());
                    Artist artist = artistService.findById(id);

                    if (artist == null) {
                        throw new IllegalArgumentException("Artist with id " + id + " not found");
                    }

                    track.getArtists().add(artist);
                    artist.getTracks().add(track);

                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid artist ID format");
                }
            }
        }

        trackRepository.save(track);
    }

    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    public void deleteTrack(String idParam) {

        if (idParam == null || idParam.isBlank()) {
            throw new IllegalArgumentException("Track ID is required");
        }

        Integer id;
        try {
            id = Integer.parseInt(idParam);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid track ID format");
        }

        Track track = trackRepository.findById(id);

        if (track == null) {
            throw new IllegalArgumentException("Track not found");
        }

        // Importante si tienes relación bidireccional
        for (Artist artist : track.getArtists()) {
            artist.getTracks().remove(track);
        }

        trackRepository.deleteById(id);
    }
}