package edu.co.icesi.examjpatemplate.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.co.icesi.examjpatemplate.entity.Bus;
import edu.co.icesi.examjpatemplate.repository.IBusRepository;

@RestController
@RequestMapping("/buses")
public class BusController {

    private final IBusRepository busRepository;

    public BusController(IBusRepository busRepository) {
        this.busRepository = busRepository;
    }


    @GetMapping("/route/{routeName}")
    public List<Bus> getBusesByRouteName(@PathVariable String routeName) {
        return busRepository.findByRouteRouteName(routeName);
    }

}