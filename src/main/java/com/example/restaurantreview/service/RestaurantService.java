
package com.example.restaurantreview.service;

import com.example.restaurantreview.entity.Restaurant;
import com.example.restaurantreview.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

//    public RestaurantService(RestaurantRepository restaurantRepository) {
//        this.restaurantRepository = restaurantRepository;
//    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findById(id).orElseThrow(() -> new RuntimeException("Restaurant not found"));
    }

    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }
//
//    public void deleteRestaurant(Long id) {
//        restaurantRepository.deleteById(id);
//    }
}
