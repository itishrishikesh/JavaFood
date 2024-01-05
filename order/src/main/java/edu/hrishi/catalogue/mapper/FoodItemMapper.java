package edu.hrishi.catalogue.mapper;

import edu.hrishi.catalogue.dto.FoodItemDto;
import edu.hrishi.catalogue.entity.FoodItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodItemMapper {
    FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);
    FoodItem foodItemDtoToFoodItem(FoodItemDto foodItemDto);
    FoodItemDto foodItemToFoodItemDto(FoodItem foodItem);
}
