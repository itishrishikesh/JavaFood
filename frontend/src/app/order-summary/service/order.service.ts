import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable, throwError } from "rxjs";
import { orderServiceUrl } from "src/app/constants/app";

export class OrderService {
    private url = orderServiceUrl + '/order';

    constructor(private http: HttpClient) {}

    httpOptions = {
        headers: new HttpHeaders({
            'Content-Type': 'text/plain',
            'Access-Control-Allow-Origin': 'http://localhost:4200'
        })
    }

    saveOrder(data: any): Observable<any> {
        return this.http.post(this.url, data);
    }

    private handleError(error: any) {
        console.error("error:", error);
        return throwError(error.message || error)
    }
}