import { Injectable } from "@angular/core";
import { Http } from "@angular/http";
import { Observable } from 'rxjs';
import { URLSearchParams } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import 'rxjs/Rx'; 
import { Prato } from "app/entity/prato";

@Injectable()
export class PratoService {

    restURL = "http://localhost:9999/api/prato";

    constructor(private http: Http) {

    }
   readByExample(prato:Prato): Promise<any> {
        return this.http.post(this.restURL + "/readByExample", prato)
        .toPromise()
        .then(res => res.json())
        .catch(this.handleError);
    }
    create(prato:Prato): Promise<any> {
        return this.http.post(this.restURL + "/create",prato)
        .toPromise()
        .then(res => res.json())
        .catch(this.handleError);
    }
    readAll(): Promise<any> {
        return this.http.get(this.restURL + "/readAll")
        .toPromise()
        .then(res => res.json())
        .catch(this.handleError);
    }
    readAllRestaurantes(): Promise<any> {
        return this.http.get("http://localhost:9999/api/restaurante/readAll")
        .toPromise()
        .then(res => res.json())
        .catch(this.handleError);
    }
    update(prato:Prato): Promise<any> {
        return this.http.put(this.restURL + "/update",prato)
        .toPromise()
        .then(res => res.json())
        .catch(this.handleError);
    }
    delete(prato:Prato): Promise<any> {
        return this.http.post(this.restURL + "/delete",prato)
        .toPromise()
        .then(res => res.json())
        .catch(this.handleError);
    }
    

    private handleError(error: any): Promise<any> {
       return Promise.reject(error.message || error);
	}
}
