package edu.hrishi.restaurant.controller;

import edu.hrishi.restaurant.dto.RestaurantDto;
import edu.hrishi.restaurant.entity.Restaurant;
import edu.hrishi.restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import mapper.RestaurantMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;
    @GetMapping("/all")
    public ResponseEntity<List<RestaurantDto>> getAllRestaurants() {
        return ResponseEntity.ok(restaurantService.getAllRestaurants());
    }

    @PostMapping
    public ResponseEntity<RestaurantDto> save(@RequestBody RestaurantDto restaurantDto) {
        restaurantService.save(restaurantDto);
        Restaurant restaurant = RestaurantMapper.INSTANCE.mapRestaurantDtoToRestaurant(restaurantDto);
        return ResponseEntity.ok(RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(restaurant));
    }
}
