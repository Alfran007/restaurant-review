package com.example.restaurantreview.controller;

import com.example.restaurantreview.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api//analytics")
public class AnalyticsController {

    private final ReviewService reviewService;

    public AnalyticsController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/average-rating/{restaurantId}")
    public Double getAverageRating(@PathVariable Long restaurantId) {
        return reviewService.getAverageRating(restaurantId);
    }

    @GetMapping("/top3-restaurants")
    public List<Long> getTop3RestaurantsByRating() {
        return reviewService.getTop3RestaurantsByRating();
    }
}
