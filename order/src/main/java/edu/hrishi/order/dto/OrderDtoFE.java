package edu.hrishi.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDtoFE {

    List<FoodItemDto> lstFoodItem;
    Integer userId;
    Restaurant restaurant;
}
