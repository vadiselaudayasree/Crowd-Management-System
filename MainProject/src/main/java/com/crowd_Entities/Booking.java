package com.crowd_Entities;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "visitor_id")
    private Visitor visitor;

    @ManyToOne
    @JoinColumn(name = "slot_id")
    private Time_slot timeSlot;

    @ManyToOne
    @JoinColumn(name = "zone_id")
    private Zone zone;

    private String status;

    private LocalDateTime bookedAt;

    private String bookingRef;
}