package com.crowd_Entities;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "visitor_id")
    private Visitor visitor;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    private String type;

//    private String channel;

    private String message;

    //private LocalDateTime sentAt;

    private String status;
}