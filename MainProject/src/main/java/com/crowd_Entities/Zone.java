package com.crowd_Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue;

    private String zoneName;

    private int maxCapacity;

    private int currentCount;

    //private String zoneType;
}
