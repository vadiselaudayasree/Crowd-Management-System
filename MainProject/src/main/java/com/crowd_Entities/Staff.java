package com.crowd_Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue;

    private String fullName;

    private String role;

    private String contact;

    private String shift;
}
