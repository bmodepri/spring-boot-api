package de.restaurantsearch.restaurant;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class RestaurantControllerTest {



    @Autowired
    RestaurantController restaurantController;

    @Before

    @Test
    public void contextLoads() {
        assertThat(restaurantController).isNotNull();
    }

    @Test
    public void getRestaurantByIdTest(){
        assertThat(restaurantController.getRestaurantById()).isInstanceOf(Restaurant.class);
    }

    @Test
    public void getRestaurantsTest(){
        assertThat(restaurantController.getRestaurants()).isInstanceOf(Restaurant.class);
    }

    @Test
    public void createRestaurantTest() {

    }

    @Test
    public void responseContentTypeIsJSON() throws IOException {

        String checkJsonMime = "application/json";


    }

}
