package edu.hrishi.restaurant.service;

import edu.hrishi.restaurant.dto.RestaurantDto;
import edu.hrishi.restaurant.entity.Restaurant;
import edu.hrishi.restaurant.repository.RestaurantRespository;
import lombok.RequiredArgsConstructor;
import edu.hrishi.restaurant.mapper.RestaurantMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRespository restaurantRespository;
    public List<RestaurantDto> getAllRestaurants() {
        return restaurantRespository.findAll().stream().map(RestaurantMapper.INSTANCE::mapRestaurantToRestaurantDto).toList();
    }

    public RestaurantDto save(RestaurantDto restaurantDto) {
        Restaurant restaurant = RestaurantMapper.INSTANCE.mapRestaurantDtoToRestaurant(restaurantDto);
        restaurant = restaurantRespository.save(restaurant);
        return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(restaurant);
    }

    public RestaurantDto getRestaurant(Integer id) {
        Restaurant restaurant = restaurantRespository.findById(id).orElseThrow();
        return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(restaurant);
    }
}
