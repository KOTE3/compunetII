package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.DroneEvent;
import com.example.demo.model.DronePosition;
import com.example.demo.repository.IDroneEventRepository;
import com.example.demo.repository.IDronePositionRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/drones")
public class DroneController {

    private final IDronePositionRepository dronePositionRepository;
    private final IDroneEventRepository droneEventRepository;

    @GetMapping("/route/{code}")
    public List<DronePosition> getDroneRoute(@PathVariable String code) {
        return dronePositionRepository.findByDroneCodeOrderByRecordedAtAsc(code);
    }
    /*
    @GetMapping("/last/{deliveryId}")
    public DroneEvent getLastEvent(@PathVariable Long deliveryId) {
        return droneEventRepository
                .findTopByDeliveryIdOrderByEventTimeDesc(deliveryId)
                .orElse(null);
}
                 */
    @GetMapping("/last/{deliveryId}")
    public DroneEvent getLastEvent(@PathVariable Long deliveryId) {
        return droneEventRepository.findFirstByDeliveryIdOrderByEventTimeDesc(deliveryId);
    }
}