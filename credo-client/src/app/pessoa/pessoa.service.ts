import { Injectable } from "@angular/core";
import { Http } from "@angular/http";
import { Pessoa } from "../entity/pessoa";
import { Observable } from 'rxjs';
import { URLSearchParams } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import 'rxjs/Rx'; 

@Injectable()
export class PessoaService {

    restURL = "http://localhost:9999/api/pessoa";

    constructor(private http: Http) {

    }
    create(pessoa:Pessoa): Promise<any> {
        return this.http.post(this.restURL + "/create",pessoa)
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
    update(pessoa:Pessoa): Promise<any> {
        return this.http.put(this.restURL + "/update",pessoa)
        .toPromise()
        .then(res => res.json())
        .catch(this.handleError);
    }
    delete(pessoa:Pessoa): Promise<any> {
        return this.http.post(this.restURL + "/delete",pessoa)
        .toPromise()
        .then(res => res.json())
        .catch(this.handleError);
    }
    

    private handleError(error: any): Promise<any> {
       return Promise.reject(error.message || error);
	}
}
