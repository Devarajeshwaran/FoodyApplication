package com.deva.foody.controller;

import com.deva.foody.entity.Meal;
import com.deva.foody.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class MealController {

    @Autowired
    private MealRepository mealRepository;

    @GetMapping("/meals")
    public Iterable<Meal> getMeals() {
        return mealRepository.findAll();
    }

    @GetMapping("/meals/{mealId}")
    public Optional<Meal> getMeal(@PathVariable Long mealId) {
        return mealRepository.findByMealId(mealId);
    }

    @PostMapping("/meals")
    public Meal createMeals(@Valid @RequestBody Meal meal) {
        return mealRepository.save(meal);
    }
}
