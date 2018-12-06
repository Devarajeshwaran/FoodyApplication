package com.deva.foody.service;

import com.deva.foody.entity.Cuisine;
import com.deva.foody.exception.ResourceNotFoundException;
import com.deva.foody.repository.CuisineRepository;
import com.deva.foody.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CuisineService {

    @Autowired
    CuisineRepository cuisineRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    public List<Cuisine> getCuisinesByRestaurant(Long restaurantId) {
        return cuisineRepository.findByRestaurantId(restaurantId);
    }

    public Cuisine createCuisinesByRestaurant(Long restaurantId, Cuisine cuisine) {
        return restaurantRepository.findById(restaurantId)
            .map(restaurant -> {
                cuisine.setRestaurant(restaurant);
                return cuisineRepository.save(cuisine);
            }).orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id " + restaurantId));
    }

    public Cuisine updateCuisinesByRestaurant(Long restaurantId, Long cuisineId, Cuisine cuisineBody) {
        if(!restaurantRepository.existsById(restaurantId)) {
            throw new ResourceNotFoundException("Restaurant not found with id " + restaurantId);
        }
        if(!cuisineRepository.existsById(cuisineId)) {
            throw new ResourceNotFoundException("Cuisine id " + cuisineId + " not found for Restaurant id " + restaurantId);
        }
        return cuisineRepository.findById(cuisineId)
            .map(cuisine -> {
                cuisine.setCuisineName(cuisineBody.getCuisineName());
                return cuisineRepository.save(cuisine);
            }).orElseThrow(() -> new ResourceNotFoundException("Cuisine id " + cuisineId + " not found for Restaurant id " + restaurantId));
    }

    public ResponseEntity<?> removeCuisinesByRestaurant(Long restaurantId, Long cuisineId) {
        if(!restaurantRepository.existsById(restaurantId)) {
            throw new ResourceNotFoundException("Restaurant not found with id " + restaurantId);
        }
        if(!cuisineRepository.existsById(cuisineId)) {
            throw new ResourceNotFoundException("Cuisine id " + cuisineId + " not found for Restaurant id " + restaurantId);
        }
        return cuisineRepository.findById(cuisineId)
            .map(cuisine -> {
                cuisineRepository.delete(cuisine);
                Map<String,String> response = new HashMap<>();
                response.put("ok", "Successfully deleted the Cuisine id " + cuisineId + " for Restaurant id " + restaurantId);
                return ResponseEntity.ok().body(response);
            }).orElseThrow(() -> new ResourceNotFoundException("Cuisine id " + cuisineId + " not found for Restaurant id " + restaurantId));
    }
}
