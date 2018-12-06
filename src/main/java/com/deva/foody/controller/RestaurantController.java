package com.deva.foody.controller;

import com.deva.foody.model.RequestModel;
import com.deva.foody.service.RestaurantService;
import com.deva.foody.entity.Restaurant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@Api(value="RestaurantController", description="Operations pertaining to Restaurant in Foody App")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @ApiOperation(value = "View a list of restaurants",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
        }
    )

    @GetMapping("/restaurants/{restaurantId}")
    public Optional<Restaurant> getRestaurant(@PathVariable Long restaurantId) {
        return restaurantService.getRestaurantById(restaurantId);
    }

    @GetMapping("/restaurants")
    public Iterable<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @PostMapping("/restaurants")
    public Restaurant createRestaurant(@Valid @RequestBody RequestModel requestModel) {
        return restaurantService.createRestaurantDetails(requestModel);
    }

    @PutMapping("/restaurants/{restaurantId}")
    public Restaurant updateRestaurant(@PathVariable Long restaurantId,
                               @Valid @RequestBody RequestModel requestModel) {
        return restaurantService.updateRestaurantDetails(restaurantId, requestModel);
    }

    @DeleteMapping("/restaurants/{restaurantId}")
    public ResponseEntity<?> deleteRestaurant(@PathVariable Long restaurantId) {
        return restaurantService.removeRestaurant(restaurantId);
    }
}
