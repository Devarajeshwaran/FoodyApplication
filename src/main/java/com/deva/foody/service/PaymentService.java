package com.deva.foody.service;

import com.deva.foody.entity.PaymentMethod;
import com.deva.foody.exception.ResourceNotFoundException;
import com.deva.foody.repository.PaymentRepository;
import com.deva.foody.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    public List<PaymentMethod> getPaymentMethodsByRestaurant(Long restaurantId) {
        return paymentRepository.findByRestaurantId(restaurantId);
    }

    public PaymentMethod createPaymentMethodsByRestaurant(Long restaurantId, PaymentMethod paymentMethod) {
        return restaurantRepository.findById(restaurantId)
                .map(restaurant -> {
                    paymentMethod.setRestaurant(restaurant);
                    return paymentRepository.save(paymentMethod);
                }).orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id " + restaurantId));
    }

    public PaymentMethod updatePaymentMethodsByRestaurant(Long restaurantId, Long paymentMethodId, PaymentMethod paymentMethodObj) {
        if(!restaurantRepository.existsById(restaurantId)) {
            throw new ResourceNotFoundException("Restaurant not found with id " + restaurantId);
        }
        if(!paymentRepository.existsById(paymentMethodId)) {
            throw new ResourceNotFoundException("Payment Method id " + paymentMethodId + " not found for Restaurant id " + restaurantId);
        }
        return paymentRepository.findById(paymentMethodId)
                .map(paymentMethod -> {
                    paymentMethod.setPaymentName(paymentMethodObj.getPaymentName());
                    return paymentRepository.save(paymentMethod);
                }).orElseThrow(() -> new ResourceNotFoundException("Payment Method id " + paymentMethodId + " not found for Restaurant id " + restaurantId));
    }

    public ResponseEntity<?> removePaymentMethodsByRestaurant(Long restaurantId, Long paymentMethodId) {
        if(!restaurantRepository.existsById(restaurantId)) {
            throw new ResourceNotFoundException("Restaurant not found with id " + restaurantId);
        }
        if(!paymentRepository.existsById(paymentMethodId)) {
            throw new ResourceNotFoundException("Payment Method id " + paymentMethodId + " not found for Restaurant id " + restaurantId);
        }
        return paymentRepository.findById(paymentMethodId)
                .map(paymentMethod -> {
                    paymentRepository.delete(paymentMethod);
                    Map<String,String> response = new HashMap<>();
                    response.put("ok", "Successfully deleted the Payment Method id " + paymentMethodId + " for Restaurant id " + restaurantId);
                    return ResponseEntity.ok().body(response);
                }).orElseThrow(() -> new ResourceNotFoundException("Payment Method id " + paymentMethodId + " not found for Restaurant id " + restaurantId));
    }
}
