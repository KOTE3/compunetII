package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Delivery;

public interface IDeliveryRepository extends JpaRepository<Delivery, Long> {

    List<Delivery> findByDroneCodeAndStatus(String droneCode, String status);
}
