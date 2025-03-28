package com.example.restaurantreview.repository;

import com.example.restaurantreview.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long>, JpaRepository<Review,Long> {

    @Query("SELECT AVG(r.rating) FROM Review r WHERE r.restaurant.id = :restaurantId")
    Double findAverageRatingByRestaurant(Long restaurantId);

    @Query("SELECT r.restaurant.id, AVG(r.rating) as avgRating FROM Review r GROUP BY r.restaurant.id ORDER BY avgRating DESC LIMIT 3")
    List<Object[]> findTop3Restaurants();

    List<Review> findByRestaurantId(Long restaurantId);


}
