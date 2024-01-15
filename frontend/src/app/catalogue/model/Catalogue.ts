import { Restaurant } from "src/app/shared/model/restaurant";
import { FoodItem } from "./FoodItem";

export interface Catalogue {
    lstFoodItems: FoodItem[];
    restaurant: Restaurant | null;
}