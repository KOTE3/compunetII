package edu.co.icesi.introspringboot.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@Data
@Entity(name = "club")
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String city;
    private LocalDate founded;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "country_id")
    private Country country;

    
    @OneToMany(mappedBy = "club")
    private List<PlayerClub> playerClubs;
}
