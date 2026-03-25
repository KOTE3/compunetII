package edu.co.icesi.examjpatemplate.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.co.icesi.examjpatemplate.entity.Bus;

public interface IBusRepository extends JpaRepository<Bus, Integer> {

    //Encontrar los buses que atienden una ruta específica por nombre de la ruta
    List<Bus> findByRouteRouteName(String routeName);

    
}
