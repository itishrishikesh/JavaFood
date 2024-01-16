import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, catchError, throwError } from "rxjs";
import { restaurantsServiceUrl } from "src/app/constants/app";

@Injectable({providedIn: 'root'})
export class RestaurantService {
    private fetchAllRestaurantsUrl = restaurantsServiceUrl + "/restaurant/all";
    constructor(private http: HttpClient) {}
    getAllRestaurants(): Observable<any> {
        return this.http.get<any>(`${this.fetchAllRestaurantsUrl}`).pipe(catchError(this.handleError));
    }
    private handleError(error: any) {
        console.error("error occurred:", error)
        return throwError(error.message || error);
    }
}