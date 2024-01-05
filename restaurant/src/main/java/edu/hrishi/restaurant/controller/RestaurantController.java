package edu.hrishi.restaurant.controller;

import edu.hrishi.restaurant.dto.RestaurantDto;
import edu.hrishi.restaurant.entity.Restaurant;
import edu.hrishi.restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import edu.hrishi.restaurant.mapper.RestaurantMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/restaurant")
@RequiredArgsConstructor
@Slf4j
public class RestaurantController {
    private final RestaurantService restaurantService;
    @GetMapping("/all")
    public ResponseEntity<List<RestaurantDto>> getAllRestaurants() {
        return ResponseEntity.ok(restaurantService.getAllRestaurants());
    }

    @PostMapping
    public ResponseEntity<RestaurantDto> save(@RequestBody RestaurantDto restaurantDto) {
        return ResponseEntity.ok(restaurantService.save(restaurantDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDto> getRestaurant(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(restaurantService.getRestaurant(id));
        } catch (NoSuchElementException e) {
            log.error("E#1Q6UH3 - Restaurant with id {} not found", id);
            return ResponseEntity.notFound().build();
        }
    }
}
