import { Component } from '@angular/core';
import { Restaurant } from 'src/app/shared/model/restaurant';
import { RestaurantService } from '../service/restaurant.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-restaurants',
  templateUrl: './restaurants.component.html',
  styleUrls: ['./restaurants.component.css']
})
export class RestaurantsComponent {
  restaurants: Restaurant[];
  ngOnInit() {
    this.getAllRestaurants();
  }
  constructor(private router: Router, private restaurantService: RestaurantService) {}
  getAllRestaurants() {
    this.restaurantService.getAllRestaurants().subscribe(data => this.restaurants = data)
  }
  getRandomNumber(min: number, max: number) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
  }
  getRandomImage(): string {
    const ImageCount = 8;
    const randomIndex = this.getRandomNumber(1, ImageCount);
    return `${randomIndex}.jpg`
  }
  onButtonClick(id: number) {
    this.router.navigate(['/food-catalogue', id])
  }
}
