package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.DroneEvent;

public interface IDroneEventRepository extends JpaRepository<DroneEvent, Long> {
    /*

    Optional<DroneEvent> findTopByDeliveryIdOrderByEventTimeDesc(Long deliveryId);
     */

    DroneEvent findFirstByDeliveryIdOrderByEventTimeDesc(Long deliveryId);

}