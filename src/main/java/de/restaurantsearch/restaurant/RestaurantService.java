package de.restaurantsearch.restaurant;

import de.restaurantsearch.Messages.ErrorMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class RestaurantService implements IRestaurantService {

    @Autowired
    IRestaurantRepository restaurantRepository;

    Logger LOGGER = LoggerFactory.getLogger(RestaurantController.class);

    @Override
    public ResponseEntity createRestaurant(Restaurant restaurant) {

        if ( restaurantRepository.existsByName(restaurant.getName()) ) {

            LOGGER.info("Tried to create restaurant with duplicated name " +  restaurant.getName());
            return new ResponseEntity(ErrorMessages.RECORD_ALREADY_EXISTS.getErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } else {

            restaurantRepository.save(restaurant);
            LOGGER.info("Restaurant " + restaurant.getName() + " Created Successfully");
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity getRestaurants() {
        // TODO: Check if the response from the repository is empty
        if (restaurantRepository.findAll() == null) {
            return new ResponseEntity(ErrorMessages.DATABASE_IS_EMPTY.getErrorMessage(), HttpStatus.NOT_FOUND);
        }
            return new ResponseEntity(restaurantRepository.findAll(), HttpStatus.OK);

    }

    @Override
    public ResponseEntity getRestaurantById(Long id) {

            if (!restaurantRepository.existsById(id)) {
                return new ResponseEntity(ErrorMessages.NO_RECORD_FOUND.getErrorMessage(), HttpStatus.NOT_FOUND);
            }else {
                return new ResponseEntity(restaurantRepository.findById(id), HttpStatus.OK);
            }
    }

    @Override
    public ResponseEntity updateRestaurant(Restaurant restaurant) {


        if( restaurantRepository.findById(restaurant.getId()) != null) {
            restaurantRepository.save(restaurant);
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(ErrorMessages.COULD_NOT_UPDATE_RECORD.getErrorMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity deleteRestaurant(Restaurant restaurant) {

        if( !restaurantRepository.existsById(restaurant.getId())) {

            return new ResponseEntity<>(ErrorMessages.COULD_NOT_DELETE_RECORD.getErrorMessage(), HttpStatus.NOT_FOUND);
        }
        else {
            restaurantRepository.delete(restaurant);
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @Override
    public ResponseEntity deleteRestaurantById(Long id) {
        if( !restaurantRepository.existsById(id)) {

            return new ResponseEntity<>(ErrorMessages.COULD_NOT_DELETE_RECORD.getErrorMessage(), HttpStatus.NOT_FOUND);
        }
        else {
            restaurantRepository.deleteById(id);
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }


}