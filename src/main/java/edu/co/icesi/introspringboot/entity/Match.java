package edu.co.icesi.introspringboot.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.NoArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@Data
@Entity(name = "match_game")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "match_date")
    private LocalDate matchDate;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "home_country_id")
    private Country homeCountry;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "away_country_id")
    private Country awayCountry;

    private String stadium;
}
