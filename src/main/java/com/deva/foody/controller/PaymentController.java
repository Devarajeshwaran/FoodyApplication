package com.deva.foody.controller;

import com.deva.foody.entity.Cuisine;
import com.deva.foody.entity.PaymentMethod;
import com.deva.foody.repository.CuisineRepository;
import com.deva.foody.repository.RestaurantRepository;
import com.deva.foody.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/restaurant/{restaurantId}/paymentMethods")
    public List<PaymentMethod> getPaymentMethods(@PathVariable Long restaurantId) {
        return paymentService.getPaymentMethodsByRestaurant(restaurantId);
    }

    @PostMapping("/restaurant/{restaurantId}/paymentMethods")
    public PaymentMethod createPaymentMethods(@PathVariable Long restaurantId, @Valid @RequestBody PaymentMethod paymentMethod) {
        return paymentService.createPaymentMethodsByRestaurant(restaurantId, paymentMethod);
    }

    @PutMapping("/restaurant/{restaurantId}/paymentMethod/{paymentMethodId}")
    public PaymentMethod updatePaymentMethods(@PathVariable Long restaurantId,
                                  @PathVariable Long paymentMethodId,
                                  @Valid @RequestBody PaymentMethod paymentMethod) {
        return paymentService.updatePaymentMethodsByRestaurant(restaurantId, paymentMethodId, paymentMethod);
    }

    @DeleteMapping("/restaurant/{restaurantId}/paymentMethod/{paymentMethodId}")
    public ResponseEntity<?> removePaymentMethods(@PathVariable Long restaurantId, @PathVariable Long paymentMethodId) {
        return paymentService.removePaymentMethodsByRestaurant(restaurantId, paymentMethodId);
    }
}
