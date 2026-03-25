package edu.co.icesi.examjpatemplate.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.co.icesi.examjpatemplate.entity.GeoPoint;
import edu.co.icesi.examjpatemplate.repository.IGeoPointsRepository;

@RestController

@RequestMapping("/geopoints")
public class GeoPointController {

    private final IGeoPointsRepository geoPointsRepository;

    public GeoPointController(IGeoPointsRepository geoPointsRepository) {
        this.geoPointsRepository = geoPointsRepository;
    }


    @GetMapping("/bus/{licensePlate}")
    public List<GeoPoint> getGeoPointsByLicensePlate(@PathVariable String licensePlate) {
        return geoPointsRepository.findByBusLicensePlateOrderByTimestampAsc(licensePlate);
    }

    @GetMapping("/bus/{licensePlate}/latest")
    public GeoPoint getLatestGeoPointByLicensePlate(@PathVariable String licensePlate) {
        return geoPointsRepository.findFirstByBusLicensePlateOrderByTimestampDesc(licensePlate);
    }

}