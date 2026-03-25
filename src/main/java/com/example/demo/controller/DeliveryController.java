package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Delivery;
import com.example.demo.repository.IDeliveryRepository;

@RestController
@RequestMapping("/delivery")
public class DeliveryController{

    private final IDeliveryRepository deliveryRepository;

    public DeliveryController(IDeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @GetMapping("/drone/{code}")
    public List<Delivery> getDeliveriesByDrone(@PathVariable String code) {
        return deliveryRepository.findByDroneCodeAndStatus(code, "COMPLETED");
    }
}