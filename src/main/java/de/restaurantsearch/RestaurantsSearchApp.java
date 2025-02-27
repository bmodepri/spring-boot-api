package de.restaurantsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan
public class RestaurantsSearchApp {

	public static void main(String[] args) {

		SpringApplication.run(
			RestaurantsSearchApp.class, 
			args);
	}

}
