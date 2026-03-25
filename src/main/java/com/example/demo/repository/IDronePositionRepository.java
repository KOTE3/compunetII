package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.DronePosition;

public interface IDronePositionRepository extends JpaRepository<DronePosition, Long> {

    List<DronePosition> findByDroneCodeOrderByRecordedAtAsc(String code);

}