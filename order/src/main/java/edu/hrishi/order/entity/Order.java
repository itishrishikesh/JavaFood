package edu.hrishi.order.entity;

import edu.hrishi.order.dto.FoodItemDto;
import edu.hrishi.order.dto.Restaurant;
import edu.hrishi.order.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer orderId;
    private List<FoodItemDto> lstFoodItems;
    private Restaurant restaurant;
    private UserDto userDto;
}
