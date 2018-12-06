package com.deva.foody.repository;

import com.deva.foody.entity.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentMethod, Long> {

    List<PaymentMethod> findByRestaurantId(Long restaurantId);
}
