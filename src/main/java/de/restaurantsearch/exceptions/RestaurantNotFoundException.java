package de.restaurantsearch.exceptions;

import de.restaurantsearch.configuration.Message;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Restaurant Not Found")
    public class RestaurantNotFoundException extends RuntimeException {
        public RestaurantNotFoundException(String message) {
            super(Message.RESTAURANT_NOT_FOUND);
        }
}
