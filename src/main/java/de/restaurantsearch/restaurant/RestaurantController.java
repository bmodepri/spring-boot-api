package de.restaurantsearch.restaurant;

import de.restaurantsearch.exceptions.ServiceUnavailableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class RestaurantController {

    @Autowired
    IRestaurantService restaurantService;

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "v1/restaurants", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable<Restaurant> getRestaurants(){
        return restaurantService.getRestaurants();
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "v1/restaurants/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Optional<Restaurant> getRestaurantById(@PathVariable("id") long id){
        return restaurantService.getRestaurantById(id);
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(value = "v1/restaurants", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createRestaurant(@RequestBody Restaurant restaurant) {
        restaurantService.createRestaurant(restaurant);
    }

    @PutMapping(value = "v1/restaurants")
    public HttpStatus updateRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.updateRestaurant(restaurant);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping(value = "v1/restaurants", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteRestaurant(@RequestBody Restaurant restaurant) {
        restaurantService.deleteRestaurant(restaurant);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping(value = "v1/restaurants/{id}")
    public void deleteRestaurantByID(@PathVariable("id") long id) {
        restaurantService.deleteRestaurantById(id);
    }
}
