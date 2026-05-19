package com.crowd_Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String location;

    private int totalCapacity;

//    private String venueType;

    private String contactInfo;
}
