package com.example.restaurantreview.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String cuisineType;
    private String address;
    private String priceRange;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Review> reviews;

//    public Restaurant(Long id, String name, String cuisineType, String address, String priceRange, List<Review> reviews) {
//        this.id = id;
//        this.name = name;
//        this.cuisineType = cuisineType;
//        this.address = address;
//        this.priceRange = priceRange;
//        this.reviews = reviews;
//    }
}