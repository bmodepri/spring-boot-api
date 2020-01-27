package de.restaurantsearch.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestaurantController {

    @Autowired
    IRestaurantService restaurantService;

    @GetMapping(value = "v1/restaurants", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable<Restaurant> getRestaurants(){
        return restaurantService.getRestaurants();
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(value = "v1/restaurants", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createRestaurant(@RequestBody Restaurant restaurant) {
        restaurantService.createRestaurant(restaurant);
    }
}
