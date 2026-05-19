package com.crowd_Entities;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Time_slot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue;

    private LocalDate slotDate;

    private LocalTime startTime;

    private LocalTime endTime;

    private int maxCapacity;

    private int bookedCount;

    private String status;
}
