package de.restaurantsearch.restaurant;

import de.restaurantsearch.exceptions.ServiceUnavailableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
