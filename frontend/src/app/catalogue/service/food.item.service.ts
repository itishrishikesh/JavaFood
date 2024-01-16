import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, catchError, throwError } from "rxjs";
import { catalogueServiceUrl } from "src/app/constants/app";

@Injectable({
    providedIn: 'root'
})
export class FoodItemService {
    private url = catalogueServiceUrl + "/food/catalogue/restaurant/";
    constructor (private http: HttpClient) {}
    getFoodItemByRestaurantId(id: number): Observable<any> {
        return this.http.get<any>(`${this.url+id}`).pipe(catchError(this.handleError))
    }
    private handleError(error: any) {
        console.error("error:", error)
        return throwError(error.message || error)
    }
}