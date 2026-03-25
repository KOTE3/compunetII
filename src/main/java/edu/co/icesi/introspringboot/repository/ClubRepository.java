package edu.co.icesi.introspringboot.repository;

import edu.co.icesi.introspringboot.entity.Club;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClubRepository extends CrudRepository<Club, Integer> {

    /**

     */
    //List<Club> findDistinctByPlayerClubs_Player_Country_HomeMatches_IdOrPlayerClubs_Player_Country_AwayMatches_Id(Integer matchId, Integer matchIdAgain);

    //2. Obtener el club donde actualmente juega un jugador dado un nombre, ignorando las mayúsculas
    List<Club> findByPlayerClubsPlayerNameIgnoreCaseAndPlayerClubsEndDateIsNull(String name);

    //4. Obtener los clubes donde sus jugadores jueguen entre dos fechas específicas y un estadio específico

    //List<Club> findByPlayerClubsPlayerCountryHomeMatchesStadiumIgnoreCaseAndPlayerClubsPlayerCountryHomeMatchesMatchDateBetween(String stadium, String startDate, String endDate);
    
}
