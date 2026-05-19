package com.crowd_Entities;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Crowd_analytics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue;

    @ManyToOne
    @JoinColumn(name = "zone_id")
    private Zone zone;

    private LocalDate recordDate;

    private LocalTime peakHourStart;

    private LocalTime peakHourEnd;

    private Integer peakCount;

    private Double avgOccupancyPct;
}
