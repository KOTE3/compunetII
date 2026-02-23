package com.example.init;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import com.example.model.Artist;
import com.example.model.Track;
import com.example.repository.impl.ArtistRepository;
import com.example.repository.impl.TrackRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitializer {

    private final ArtistRepository artistRepository;
    private final TrackRepository trackRepository;

    public DataInitializer(ArtistRepository artistRepository,
            TrackRepository trackRepository) {
        this.artistRepository = artistRepository;
        this.trackRepository = trackRepository;
    }

    @PostConstruct
    public void init() {

        List<Artist> artists = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            Artist artist = new Artist();
            artist.setName("Artist " + i);
            artist.setNationality("Country " + i);
            artistRepository.save(artist);
            artists.add(artist);
        }

        int trackCounter = 1;

        for (int i = 0; i < artists.size(); i++) {

            Artist artist = artists.get(i);

            for (int j = 1; j <= 5; j++) { // 5 tracks por artista

                Track track = new Track();
                track.setTitle("Track " + trackCounter);
                track.setGenre("Genre " + ((trackCounter % 5) + 1));
                track.setDuration(180 + trackCounter);
                track.setAlbumTitle("Album " + i);

                // Relación bidireccional
                track.getArtists().add(artist);
                artist.getTracks().add(track);

                trackRepository.save(track);

                trackCounter++;
            }
        }

        System.out.println("Datos inicializados correctamente");
    }
}