package com.deva.foody.repository;

import com.deva.foody.entity.Meal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MealRepository extends CrudRepository<Meal, Long> {

    Optional<Meal> findByMealId(Long aLong);

    Iterable<Meal> findAll();
}
