package de.restaurantsearch.restaurant;

import de.restaurantsearch.Messages.ErrorMessages;
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

    @GetMapping(value = "v1/restaurants", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity getRestaurants() {

            return restaurantService.getRestaurants();
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "v1/restaurants/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional> getRestaurantById(@PathVariable("id") Long id) throws Exception {

        if ( !(id instanceof Long) ) throw new Exception(ErrorMessages.INVALID_ID.getErrorMessage());

            return restaurantService.getRestaurantById(id);
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(value = "v1/restaurants", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createRestaurant(@RequestBody Restaurant restaurant) throws Exception {

        if(restaurant.getName().isEmpty()) {
            throw new Exception(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
        }else{
           return restaurantService.createRestaurant(restaurant);
        }

    }

    @PutMapping(value = "v1/restaurants")
    public ResponseEntity updateRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.updateRestaurant(restaurant);
    }

    @DeleteMapping(value = "v1/restaurants", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteRestaurant(@RequestBody Restaurant restaurant) throws Exception {
        return restaurantService.deleteRestaurant(restaurant);
    }

    @DeleteMapping(value = "v1/restaurants/{id}")
    public ResponseEntity deleteRestaurantByID(@PathVariable("id") long id) {
        return restaurantService.deleteRestaurantById(id);
    }

}