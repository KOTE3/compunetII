package edu.co.icesi.examjpatemplate.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.co.icesi.examjpatemplate.entity.GeoPoint;

public interface IGeoPointsRepository extends JpaRepository<GeoPoint, Integer> {

    //Obtener el recorrido de un bus por placa, esto es, obtener cada posición registrada ordenada por tiempo para el bus seleccionado
    List<GeoPoint> findByBusLicensePlateOrderByTimestampAsc(String licensePlate);

    //Obtener la ubicación más reciente registrada de un bus según su matrícula
    GeoPoint findFirstByBusLicensePlateOrderByTimestampDesc(String licensePlate);

}
