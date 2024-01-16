import { FoodItem } from "src/app/catalogue/model/FoodItem";
import { Restaurant } from "src/app/shared/model/restaurant";

export interface OrderDto {
    lstFoodItem?: FoodItem[];
    userId?: number;
    restaurant?: Restaurant;
}