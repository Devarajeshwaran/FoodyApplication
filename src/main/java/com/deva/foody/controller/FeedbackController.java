package com.deva.foody.controller;

import com.deva.foody.entity.Cuisine;
import com.deva.foody.entity.Feedback;
import com.deva.foody.repository.CuisineRepository;
import com.deva.foody.repository.FeedbackRepository;
import com.deva.foody.repository.RestaurantRepository;
import com.deva.foody.service.CuisineService;
import com.deva.foody.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class FeedbackController {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/restaurant/{restaurantId}/feedbacks")
    public List<Feedback> getfeedbacks(@PathVariable Long restaurantId) {
        return feedbackService.getfeedbacksByRestaurant(restaurantId);
    }

    @PostMapping("/restaurant/{restaurantId}/member/{memberId}/feedbacks")
    public Feedback createFeedbacks(@PathVariable Long restaurantId, @PathVariable Long memberId, @Valid @RequestBody Feedback feedback) {
        return feedbackService.createFeedbacksByRestaurant(restaurantId, memberId, feedback);
    }

    @DeleteMapping("/restaurant/{restaurantId}/feedbacks/{feedbackId}")
    public ResponseEntity<?> deleteFeedbacks(@PathVariable Long restaurantId, @PathVariable Long feedbackId) {
        return feedbackService.removeFeedbacksByRestaurant(restaurantId, feedbackId);
    }
}
