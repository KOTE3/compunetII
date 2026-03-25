package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Delivery;

public interface IDeliveryRepository extends JpaRepository<Delivery, Long> {

    List<Delivery> findByDroneCodeAndStatus(String droneCode, String status);
}


//Obtener los jugadores de una confederación específica, ordenados por fifa_score de maneradescendente.
  //List<Player> findByCountryConfederationOrderByFifaScoreDesc(String confederation);

  //Obtener el club donde actualmente juega un jugador dado un nombre, ignorando las mayúsculas
  //List<Club> findByPlayerClubsPlayerNameIgnoreCaseAndPlayerClubsEndDateIsNull(String name);

  //Obtener los clubes donde sus jugadores jueguen entre dos fechas específicas y un estadio específico
//List<Club> findByPlayerClubsPlayerCountryHomeMatchesStadiumIgnoreCaseAndPlayerClubsPlayerCountryHomeMatchesMatchDateBetween(String stadium, String startDate, String endDate);

 //5. Obtener los partidos en los que participan jugadores con posición de delantero pertenecientes a un club específico.
//List<Match> findByHomeCountryPlayersPositionAndHomeCountryPlayersPlayerClubsClubName(String position, String clubName);