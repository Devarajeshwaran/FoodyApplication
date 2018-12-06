package com.deva.foody.service;

import com.deva.foody.entity.Cuisine;
import com.deva.foody.entity.Feedback;
import com.deva.foody.entity.Member;
import com.deva.foody.entity.Restaurant;
import com.deva.foody.exception.ResourceNotFoundException;
import com.deva.foody.repository.CuisineRepository;
import com.deva.foody.repository.FeedbackRepository;
import com.deva.foody.repository.MemberRepository;
import com.deva.foody.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.management.OperatingSystemMXBean;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class FeedbackService {
    @Autowired
    FeedbackRepository feedbackRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    MemberRepository memberRepository;

    public List<Feedback> getfeedbacksByRestaurant(Long restaurantId) {
        return feedbackRepository.findByRestaurantId(restaurantId);
    }

//    public Feedback createFeedbacksByRestaurant(Long restaurantId, Long memberId, Feedback feedback) {
//        if(!memberRepository.existsById(memberId)){
//            throw new ResourceNotFoundException("Member not found with id " + memberId);
//        }
//        if (!restaurantRepository.existsById(restaurantId)) {
//            throw new ResourceNotFoundException("Restaurant not found with id " + restaurantId);
//        }
//
//
////        restaurantRepository.findById(restaurantId)
////                .map(restaurant -> {
////                    feedback.setRestaurant(restaurant);
////                    return feedbackRepository.save(feedback);
////                }).orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id " + restaurantId));
////
////        return memberRepository.findById(memberId)
////                .map(member -> {
////                    feedback.setMember(member);
////                    return feedbackRepository.save(feedback);
////                }).orElseThrow(() -> new ResourceNotFoundException("Member not found with id " + memberId));
//
//
//    }

    public ResponseEntity<?> removeFeedbacksByRestaurant(Long restaurantId, Long feedbackId) {
        if (!restaurantRepository.existsById(restaurantId)) {
            throw new ResourceNotFoundException("Restaurant not found with id " + restaurantId);
        }
        if (!feedbackRepository.existsById(feedbackId)) {
            throw new ResourceNotFoundException("Feedback id " + feedbackId + " not found for Restaurant id " + restaurantId);
        }
        return feedbackRepository.findById(feedbackId)
                .map(feedback -> {
                    feedbackRepository.delete(feedback);
                    Map<String, String> response = new HashMap<>();
                    response.put("ok", "Successfully deleted the Feedback id " + feedbackId + " for Restaurant id " + restaurantId);
                    return ResponseEntity.ok().body(response);
                }).orElseThrow(() -> new ResourceNotFoundException("Feedback id " + feedbackId + " not found for Restaurant id " + restaurantId));
    }
}
