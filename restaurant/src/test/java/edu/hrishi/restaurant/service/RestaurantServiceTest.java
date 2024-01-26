package edu.hrishi.restaurant.service;

import edu.hrishi.restaurant.dto.RestaurantDto;
import edu.hrishi.restaurant.entity.Restaurant;
import edu.hrishi.restaurant.mapper.RestaurantMapper;
import edu.hrishi.restaurant.repository.RestaurantRespository;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class RestaurantServiceTest {
    @InjectMocks
    RestaurantService restaurantService;
    @Mock
    RestaurantRespository restaurantRespository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllRestaurants() {
        // Arrange
        List<Restaurant> mockRestaurantList = Arrays.asList(new Restaurant(1, "Moti Mahal", "202, Sadar Bazaar", "Atlantic", "Best Place for North Indian Food"), new Restaurant(2, "Mocka", "104, Mahal", "Nagpur", "Best Place for Coffee"));
        Mockito.when(restaurantRespository.findAll()).thenReturn(mockRestaurantList);
        // Act
        List<RestaurantDto> result = restaurantService.getAllRestaurants();
        // Assert
        long count = result.stream().filter(restaurantDto -> {
            Restaurant restaurant = RestaurantMapper.INSTANCE.mapRestaurantDtoToRestaurant(restaurantDto);
            return mockRestaurantList.contains(restaurant);
        }).count();
        Assertions.assertEquals(2, count);
        // Verify that restaurant repository is mocked.
        Mockito.verify(restaurantRespository, Mockito.times(1)).findAll();
    }

    @Test
    public void testSave() {
        Restaurant restaurant = new Restaurant(1, "ABC", "ABC", "BCD", "ADV");
        Mockito.when(restaurantRespository.save(restaurant)).thenReturn(restaurant);
        RestaurantDto restaurantDto = restaurantService.save(RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(restaurant));
        Assertions.assertEquals(
                restaurant,
                RestaurantMapper.INSTANCE.mapRestaurantDtoToRestaurant(restaurantDto)
        );
        Mockito.verify(restaurantRespository, Mockito.times(1)).save(restaurant);
    }

    @Test
    public void testGetRestaurant() {
        Restaurant restaurant = new Restaurant(1, "ABC", "ABC", "BCD", "ADV");
        Mockito.when(restaurantRespository.findById(1)).thenReturn(Optional.of(restaurant));
        RestaurantDto restaurantDto = restaurantService.getRestaurant(1);
        Assertions.assertEquals(restaurant, RestaurantMapper.INSTANCE.mapRestaurantDtoToRestaurant(restaurantDto));
        Mockito.verify(restaurantRespository, Mockito.times(1)).findById(1);
    }
}
