package de.restaurantsearch.restaurant;

public interface IRestaurantService {

    void createRestaurant(Restaurant restaurant);
    Iterable<Restaurant> getRestaurants();
}
