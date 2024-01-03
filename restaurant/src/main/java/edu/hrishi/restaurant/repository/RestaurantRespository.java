package edu.hrishi.restaurant.repository;

import edu.hrishi.restaurant.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRespository extends JpaRepository<Restaurant, Integer> {
}
