package com.deva.foody.repository;

import com.deva.foody.entity.Cuisine;
import com.deva.foody.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    List<Feedback> findByRestaurantId(Long restaurantId);
}
