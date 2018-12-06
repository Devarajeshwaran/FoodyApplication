package com.deva.foody.repository;

import com.deva.foody.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    Optional<Restaurant> findById(Long restId);

//    Iterable<Restaurant> findAll();
}
