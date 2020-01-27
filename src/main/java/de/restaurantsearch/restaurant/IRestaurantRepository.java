package de.restaurantsearch.restaurant;

import de.restaurantsearch.exceptions.ServiceUnavailableException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRestaurantRepository extends CrudRepository<Restaurant, Long> {

    @Override
    Iterable<Restaurant> findAll();

}
