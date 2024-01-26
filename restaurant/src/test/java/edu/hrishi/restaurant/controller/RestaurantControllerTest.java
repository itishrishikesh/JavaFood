package edu.hrishi.restaurant.controller;

import edu.hrishi.restaurant.dto.RestaurantDto;
import edu.hrishi.restaurant.service.RestaurantService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class RestaurantControllerTest {
    @InjectMocks
    RestaurantController restaurantController;

    @Mock
    RestaurantService restaurantService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllRestaurants() {
        // Arrange
        List<RestaurantDto> mockRestaurantList = Arrays.asList(new RestaurantDto(1, "Moti Mahal", "202, Sadar Bazaar", "Atlantic", "Best Place for North Indian Food"), new RestaurantDto(2, "Mocka", "104, Mahal", "Nagpur", "Best Place for Coffee"));
        Mockito.when(restaurantService.getAllRestaurants()).thenReturn(mockRestaurantList);
        // Act
        ResponseEntity<List<RestaurantDto>> response = restaurantController.getAllRestaurants();
        // Assert
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(mockRestaurantList, response.getBody());
        // Verify that restaurant service is called.
        Mockito.verify(restaurantService, Mockito.times(1)).getAllRestaurants();
    }

    @Test
    public void testSave() {
        // Arrange
        RestaurantDto mockRestaurant = new RestaurantDto(1, "Moti Mahal", "202, Sadar Bazaar", "Atlantic", "Best Place for North Indian Food");
        Mockito.when(restaurantService.save(mockRestaurant)).thenReturn(mockRestaurant);
        // Act
        ResponseEntity<RestaurantDto> response = restaurantController.save(mockRestaurant);
        // Assert
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertEquals(mockRestaurant, response.getBody());
        // Verify that restaurant service is called.
        Mockito.verify(restaurantService, Mockito.times(1)).save(mockRestaurant);
    }

    @Test
    public void testGetRestaurant() {
        // Arrange
        RestaurantDto mockRestaurant = new RestaurantDto(1, "Moti Mahal", "202, Sadar Bazaar", "Atlantic", "Best Place for North Indian Food");
        Mockito.when(restaurantService.getRestaurant(1)).thenReturn(mockRestaurant);
        // Act
        ResponseEntity<RestaurantDto> response = restaurantController.getRestaurant(1);
        // Assert
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(mockRestaurant, response.getBody());
        // Verify that restaurant service is called.
        Mockito.verify(restaurantService, Mockito.times(1)).getRestaurant(1);
    }

    @Test
    public void testGetRestaurantNotFound() {
        // Arrange
        Mockito.when(restaurantService.getRestaurant(1)).thenThrow(NoSuchElementException.class);
        // Act
        ResponseEntity<RestaurantDto> response = restaurantController.getRestaurant(1);
        // Assert
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        // Verify that restaurant service is called.
        Mockito.verify(restaurantService, Mockito.times(1)).getRestaurant(1);
    }
}
