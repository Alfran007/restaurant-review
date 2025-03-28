package com.example.restaurantreview.service;

import com.example.restaurantreview.entity.PriceRange;
import com.example.restaurantreview.entity.Restaurant;
import com.example.restaurantreview.repository.RestaurantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

class RestaurantServiceTest {

    @Mock
    private RestaurantRepository restaurantRepository;

    @InjectMocks
    private RestaurantService restaurantService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllRestaurants_returnsAllRestaurants() {
        List<Restaurant> restaurants = Arrays.asList(
                new Restaurant(1L, "Test Restaurant1", "Dessert", "Test Location", PriceRange.LOW, new ArrayList<>()),
                new Restaurant(2L, "Test Restaurant2", "Cuisine", "Test Location", PriceRange.HIGH, new ArrayList<>())
        );
        when(restaurantRepository.findAll()).thenReturn(restaurants);

        List<Restaurant> result = restaurantService.getAllRestaurants();
        assertEquals(2, result.size());
        verify(restaurantRepository, times(1)).findAll();
    }

    @Test
    void addRestaurant_savesAndReturnsRestaurant() {
        Restaurant restaurant = new Restaurant(1L, "New Restaurant", "Cuisine", "Test Location", PriceRange.HIGH, new ArrayList<>());
        when(restaurantRepository.save(restaurant)).thenReturn(restaurant);

        Restaurant result = restaurantService.addRestaurant(restaurant);
        assertEquals("New Restaurant", result.getName());
        verify(restaurantRepository, times(1)).save(restaurant);
    }

    @Test
    void getRestaurantById_returnsRestaurant_whenIdExists() {
        Restaurant restaurant = new Restaurant(1L, "Test Restaurant", "Cuisine", "Test Location", PriceRange.HIGH, new ArrayList<>());
        when(restaurantRepository.findById(1L)).thenReturn(Optional.of(restaurant));

        Restaurant result = restaurantService.getRestaurantById(1L);
        assertEquals("Test Restaurant", result.getName());
        verify(restaurantRepository, times(1)).findById(1L);
    }

//    @Test
//    void getRestaurantById_returnsNull_whenIdDoesNotExist() {
//        when(restaurantRepository.findById(1L)).thenReturn(Optional.empty());
//
//        Restaurant result = restaurantService.getRestaurantById(1L);
//        assertNull(result);
//        verify(restaurantRepository, times(1)).findById(1L);
//    }
}