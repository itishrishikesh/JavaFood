package edu.hrishi.catalogue.controller;

import edu.hrishi.catalogue.dto.FoodCataloguePage;
import edu.hrishi.catalogue.dto.FoodItemDto;
import edu.hrishi.catalogue.dto.Restaurant;
import edu.hrishi.catalogue.entity.FoodItem;
import edu.hrishi.catalogue.service.FoodCatalogueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/food/catalogue")
public class FoodCatalogueController {
    private final FoodCatalogueService foodCatalogueService;
    private final RestTemplate restTemplate;

    @PostMapping("/item")
    public ResponseEntity<FoodItemDto> saveFoodItem(@RequestBody FoodItemDto foodItemDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(foodCatalogueService.saveFoodItem(foodItemDto));
    }

    @GetMapping("/restaurant/{id}")
    public ResponseEntity<FoodCataloguePage> getFoodCatalogue(@PathVariable Integer id) {
        Restaurant restaurant = restTemplate.getForObject("http://restaurant/" + id, Restaurant.class);
        List<FoodItem> lstFoodItems = foodCatalogueService.getFoodItemsByRestaurantId(id);
        return ResponseEntity.ok(new FoodCataloguePage(lstFoodItems, restaurant));
    }

}
