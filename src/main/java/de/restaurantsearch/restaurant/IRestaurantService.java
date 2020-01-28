package de.restaurantsearch.restaurant;

import de.restaurantsearch.exceptions.RestaurantNotFoundException;
import de.restaurantsearch.exceptions.ServiceUnavailableException;
import org.springframework.http.HttpStatus;

import java.util.Optional;

public interface IRestaurantService {

    void createRestaurant(Restaurant restaurant);

    Iterable<Restaurant> getRestaurants();

    Optional<Restaurant> getRestaurantById (Long id) throws RestaurantNotFoundException;

    HttpStatus updateRestaurant(Restaurant restaurant) throws RestaurantNotFoundException;

    void deleteRestaurant(Restaurant restaurant) throws RestaurantNotFoundException;

    void deleteRestaurantById(Long id) throws RestaurantNotFoundException;
}
