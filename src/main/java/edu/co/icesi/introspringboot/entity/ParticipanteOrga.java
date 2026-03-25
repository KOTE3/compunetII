package edu.co.icesi.introspringboot.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.NoArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@Data
@Entity(name = "player_club")
public class ParticipanteOrga {

    @EmbeddedId
    private ParticiOrgaId id;

    @ManyToOne
    @JsonIgnore
    @MapsId("playerId")
    @JoinColumn(name = "player_id")
    private Participante player;

    @ManyToOne
    @JsonIgnore
    @MapsId("clubId")
    @JoinColumn(name = "club_id")
    private Organizacion club;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;


}
