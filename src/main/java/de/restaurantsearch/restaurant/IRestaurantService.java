package de.restaurantsearch.restaurant;

import org.springframework.http.ResponseEntity;

public interface IRestaurantService {

    ResponseEntity createRestaurant(Restaurant restaurant);

    ResponseEntity getRestaurants();

    ResponseEntity getRestaurantById (Long id);

    ResponseEntity updateRestaurant(Restaurant restaurant);

    ResponseEntity deleteRestaurant(Restaurant restaurant);

    ResponseEntity deleteRestaurantById(Long id);
}