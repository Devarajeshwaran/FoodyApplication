package com.deva.foody.repository;

import com.deva.foody.entity.Cuisine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuisineRepository extends JpaRepository<Cuisine, Long> {

//    List<Cuisine> findByCuisineId(Long aLong);

//    Iterable<Cuisine> findAll();

    List<Cuisine> findByRestaurantId(Long restaurantId);
}
