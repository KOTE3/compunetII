package edu.co.icesi.introspringboot.repository;

import edu.co.icesi.introspringboot.entity.Match;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends CrudRepository<Match, Integer> {

    /**
     Solo locales
     */
    //List<Match> findDistinctByHomeCountry_Players_PlayerClubs_Club_NameAndHomeCountry_Players_PlayerClubs_EndDateIsNull(String clubName);

    //3.Obtén los partidos jugados en un estadio específico, donde el país local tenga al menos un jugador |con un fifaScore mayor a un valor dado
    List<Match> findByStadiumIgnoreCaseAndHomeCountryPlayersFifaScoreGreaterThan(String stadium, Integer score);

    //5. Obtener los partidos en los que participan jugadores con posición de delantero pertenecientes a un club específico.

    List<Match> findByHomeCountryPlayersPositionAndHomeCountryPlayersPlayerClubsClubName(String position, String clubName);

}
