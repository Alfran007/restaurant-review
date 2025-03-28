package com.example.restaurantreview.service;

import com.example.restaurantreview.entity.Review;
import com.example.restaurantreview.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Double getAverageRating(Long restaurantId) {
        return reviewRepository.findAverageRatingByRestaurant(restaurantId);
    }

    public List<Long> getTop3RestaurantsByRating() {
        return reviewRepository.findTop3Restaurants()
                .stream()
                .map(result -> (Long) result[0]) // Extract restaurant ID
                .collect(Collectors.toList());
    }
    public Review getReviewById(Long id) {
        return reviewRepository.findById(id).orElseThrow(() -> new RuntimeException("Review not found"));
    }

    public List<Review> getReviewsByRestaurant(Long restaurantId) {
        return reviewRepository.findByRestaurantId(restaurantId);
    }


    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }
}
