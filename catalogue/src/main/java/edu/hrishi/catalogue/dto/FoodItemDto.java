package edu.hrishi.catalogue.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItemDto {
    private int id;
    private String name;
    private String description;
    private boolean isVeg;
    private Number price;
    private Integer restaurantId;
    private Integer quantity;
}
