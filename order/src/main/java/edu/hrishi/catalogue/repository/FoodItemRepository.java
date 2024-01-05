package edu.hrishi.catalogue.repository;

import edu.hrishi.catalogue.entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodItemRepository extends JpaRepository<FoodItem, Integer> {
    List<FoodItem> findByRestaurantId(Integer id);
}
