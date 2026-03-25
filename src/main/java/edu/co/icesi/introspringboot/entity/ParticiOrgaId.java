package edu.co.icesi.introspringboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;
import lombok.NoArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@Data
@Embeddable
public class ParticiOrgaId implements Serializable {

    @Column(name = "player_id")
    private Integer playerId;

    @Column(name = "club_id")
    private Integer clubId;
    
}
