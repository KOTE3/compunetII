package com.example.demo.model;
import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "deliveries")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tracking_code", nullable = false)
    private String trackingCode;

    private String status;

    private String destination;
    
    @Column(name = "assigned_at", nullable = false)
    private Timestamp assignedAt;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "drone_id", nullable = false)
    private Drone drone;

    @OneToMany(mappedBy = "delivery")
    private List<DroneEvent> droneEvents;

}
