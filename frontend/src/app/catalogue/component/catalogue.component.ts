import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FoodItemService } from '../service/food.item.service';
import { Catalogue } from '../model/Catalogue';
import { FoodItem } from '../model/FoodItem';

@Component({
  selector: 'app-catalogue',
  templateUrl: './catalogue.component.html',
  styleUrls: ['./catalogue.component.css']
})
export class CatalogueComponent {

  restaurantId: number;
  foodItemResponse: Catalogue;
  foodItemCart: FoodItem[] = []
  orderSummary: Catalogue;

  constructor(private route: ActivatedRoute, private foodItemService: FoodItemService, private router: Router) {

  }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
        console.log("params.get('id')" + params.get('id'));
        this.restaurantId = parseInt(params.get('id') ?? "0");
    })
    this.getFoodItemsByRestaurant(this.restaurantId)
  }

  getFoodItemsByRestaurant(restaurant: number) {
    this.foodItemService.getFoodItemByRestaurantId(this.restaurantId).subscribe(
      data => {
        this.foodItemResponse = data;
      }
    )
  }

  increment(food: any) {
    food.quantity++;
    const index = this.foodItemCart.findIndex(item => item.id === food.id);
    if(index == -1) {
      this.foodItemCart.push(food)
    } else {
      this.foodItemCart[index] = food;
    }
  }

  decrement(food: any) {
    if (food.quantity > 0) {
      food.quantity--;
    }
    const index = this.foodItemCart.findIndex(item => item.id === food.id);
    if (this.foodItemCart[index].quantity == 0) {
      this.foodItemCart.splice(index, 1);
    } else {
      this.foodItemCart[index] = food;
    }
  }

  onCheckout() {
    this.foodItemCart;
    this.orderSummary = {
      lstFoodItems: [],
      restaurant: null
    }
    this.orderSummary.lstFoodItems = this.foodItemCart;
    this.orderSummary.restaurant = this.foodItemResponse.restaurant;
    this.router.navigate(['/orderSummary'], {queryParams: {data: JSON.stringify(this.orderSummary)}})
  }
}
