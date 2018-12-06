package com.deva.foody.controller;

import com.deva.foody.service.CuisineService;
import com.deva.foody.entity.Cuisine;
import com.deva.foody.repository.CuisineRepository;
import com.deva.foody.repository.RestaurantRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(value="CuisineController", description="Operations pertaining to Cuisine in Foody App")
public class CuisineController {

    @Autowired
    private CuisineRepository cuisineRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private CuisineService cuisineService;

    @GetMapping("/restaurant/{restaurantId}/cuisines")
    public List<Cuisine> getCuisine(@PathVariable Long restaurantId) {
        return cuisineService.getCuisinesByRestaurant(restaurantId);
    }

    @PostMapping("/restaurant/{restaurantId}/cuisines")
    public Cuisine createCuisines(@PathVariable Long restaurantId, @Valid @RequestBody Cuisine cuisine) {
        return cuisineService.createCuisinesByRestaurant(restaurantId, cuisine);
    }

    @PutMapping("/restaurant/{restaurantId}/cuisines/{cuisineId}")
    public Cuisine updateCuisines(@PathVariable Long restaurantId,
                                       @PathVariable Long cuisineId,
                                       @Valid @RequestBody Cuisine cuisine) {
        return cuisineService.updateCuisinesByRestaurant(restaurantId, cuisineId, cuisine);
    }

    @DeleteMapping("/restaurant/{restaurantId}/cuisines/{cuisineId}")
    public ResponseEntity<?> deleteRestaurant(@PathVariable Long restaurantId, @PathVariable Long cuisineId) {
        return cuisineService.removeCuisinesByRestaurant(restaurantId, cuisineId);
    }
}
