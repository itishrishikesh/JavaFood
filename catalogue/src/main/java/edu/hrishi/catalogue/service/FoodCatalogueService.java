package edu.hrishi.catalogue.service;

import edu.hrishi.catalogue.dto.FoodItemDto;
import edu.hrishi.catalogue.entity.FoodItem;
import edu.hrishi.catalogue.mapper.FoodItemMapper;
import edu.hrishi.catalogue.repository.FoodItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodCatalogueService {
    private final FoodItemRepository foodItemRepository;

    public FoodItemDto saveFoodItem(FoodItemDto foodItemDto) {
        FoodItem item = foodItemRepository.save(FoodItemMapper.INSTANCE.foodItemDtoToFoodItem(foodItemDto));
        return FoodItemMapper.INSTANCE.foodItemToFoodItemDto(item);
    }

    public List<FoodItem> getFoodItemsByRestaurantId(Integer id) {
        return foodItemRepository.findByRestaurantId(id);
    }
}
