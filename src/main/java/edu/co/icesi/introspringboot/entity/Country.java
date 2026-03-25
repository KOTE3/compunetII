package edu.co.icesi.introspringboot.entity;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@Data
@Entity(name = "country")
public class Country {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String code;
    private String confederation;

    @OneToMany(mappedBy = "homeCountry")
    private List<Match> homeMatches;

    @OneToMany(mappedBy = "awayCountry")
    private List<Match> awayMatches;

    @OneToMany(mappedBy = "country")
    private List<Player> players;

    @OneToMany(mappedBy = "country")
    private List<Club> clubs;
}