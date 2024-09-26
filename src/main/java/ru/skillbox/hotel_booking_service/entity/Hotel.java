package ru.skillbox.hotel_booking_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
@Entity
@Table(name = "hotels")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String announcement;
    private String city;
    private String address;
    private double distanceFromCityCenter;

    //@Min(1)
    //@Max(5)
    private int rating;

    private int ratingCount;
}