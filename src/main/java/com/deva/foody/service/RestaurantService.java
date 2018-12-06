package com.deva.foody.service;

import com.deva.foody.model.CommonModel;
import com.deva.foody.model.RequestModel;
import com.deva.foody.entity.Restaurant;
import com.deva.foody.exception.ResourceNotFoundException;
import com.deva.foody.mapper.Mapper;
import com.deva.foody.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    private static final Mapper mapper = new Mapper();

    public Optional<Restaurant> getRestaurantById(Long restaurantId){
        return restaurantRepository.findById(restaurantId);
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant createRestaurantDetails(RequestModel requestModel) {
        CommonModel mappedObj = mapper.RequestToModelMapper(requestModel);
        Restaurant restaurant = mapper.ModelToEntityMapper(mappedObj);
        Restaurant restaurantObj = restaurantRepository.save(restaurant);
        return restaurantObj;
    }

    public Restaurant updateRestaurantDetails(Long restaurantId, RequestModel requestModel) {
        if(!restaurantRepository.existsById(restaurantId)) {
            throw new ResourceNotFoundException("Restaurant not found with id " + restaurantId);
        }
        return restaurantRepository.findById(restaurantId)
            .map(restaurant -> {
                restaurant.setIsDeliveryCharge(requestModel.getIsDeliveryCharge());
                restaurant.setPhoneNo(requestModel.getPhoneNo());
                restaurant.setHomeDeliveryOption(requestModel.getHomeDeliveryOption());
                restaurant.setRestaurantName(requestModel.getRestaurantName());
                restaurant.setDeliveryCharge(requestModel.getDeliveryCharge());
                restaurant.setOpeningTime(requestModel.getOpeningTime());
                restaurant.setDeliveryWeekEndTime(requestModel.getDeliveryWeekEndTime());
                restaurant.setDeliveryWeekDaysTime(requestModel.getDeliveryWeekDaysTime());
                restaurant.setAddress(requestModel.getAddress());
                return restaurantRepository.save(restaurant);
            }).orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id " + restaurantId));
    }

    public ResponseEntity<?> removeRestaurant(Long restaurantId) {
        if(!restaurantRepository.existsById(restaurantId)) {
            throw new ResourceNotFoundException("Restaurant not found with id " + restaurantId);
        }
        return restaurantRepository.findById(restaurantId)
            .map(restaurant -> {
                restaurantRepository.delete(restaurant);
                Map<String,String> response = new HashMap<>();
                response.put("ok", "Successfully deleted the Restaurant" + restaurantId);
                return ResponseEntity.ok().body(response);
            }).orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id " + restaurantId));
    }
}
