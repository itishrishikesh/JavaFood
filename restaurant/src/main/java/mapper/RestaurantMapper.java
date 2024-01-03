package mapper;


import edu.hrishi.restaurant.dto.RestaurantDto;
import edu.hrishi.restaurant.entity.Restaurant;
import org.mapstruct.factory.Mappers;

public interface RestaurantMapper {
    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    Restaurant mapRestaurantDtoToRestaurant(RestaurantDto restaurantDto);

    RestaurantDto mapRestaurantToRestaurantDto(Restaurant restaurant);

}
