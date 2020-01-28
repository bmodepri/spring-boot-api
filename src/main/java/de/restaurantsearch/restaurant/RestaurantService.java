package de.restaurantsearch.restaurant;

import de.restaurantsearch.exceptions.RestaurantNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class RestaurantService implements IRestaurantService {

    @Autowired
    IRestaurantRepository restaurantRepository;

    @Override
    public void createRestaurant(Restaurant restaurant) {

        restaurantRepository.save(restaurant);
    }

    @Override
    public Iterable<Restaurant> getRestaurants() {

        return restaurantRepository.findAll();
    }

    @Override
    public Optional<Restaurant> getRestaurantById(Long id) throws RestaurantNotFoundException {
        try {
            restaurantRepository.existsById(id) ;
        } catch (RestaurantNotFoundException e) {
            e.getMessage();
        }
        return restaurantRepository.findById(id);
    }

    @Override
    public HttpStatus updateRestaurant(Restaurant restaurant) throws RestaurantNotFoundException {

        if( !restaurantRepository.existsById(restaurant.getId())) {

            return HttpStatus.NOT_FOUND;
        }
        else {
            restaurantRepository.save(restaurant);
            return HttpStatus.OK;
        }
    }

    @Override
    public void deleteRestaurant(Restaurant restaurant) throws RestaurantNotFoundException {
        restaurantRepository.delete(restaurant);
    }

    @Override
    public void deleteRestaurantById(Long id) throws RestaurantNotFoundException {
        try {
            restaurantRepository.existsById(id);
            restaurantRepository.deleteById(id);
        } catch (RestaurantNotFoundException e) {
            e.getMessage();
        }
    }
}
