import { tap } from "rxjs";
import { HttpClient, HttpHeaders } from '@angular/common/http';

export class BaseService {
    baseUrl = 'http://172.20.10.2:8080';

    private httpHeaders = {
        headers: new HttpHeaders({
            'Content-Type':  'application/json',
        })
    };

    constructor (
        protected http: HttpClient
    ) {}

    /**
     * Send a POST request
     * @param url
     * @param data
     * @returns {Promise<Object>}
     */
    protected async post(url: string, data: any){
        return this.http.post(this.baseUrl + url, data, this.httpHeaders).pipe(
            tap({
                error: (error: any) => {
                    if (error.status === 500) {
                        // Handle 500
                    } else if (error.status === 400) {
                        // Handle 400
                    } else if (error.status === 401) {
                        // Handle 401
                    }
                }})).toPromise();
    }

    /**
     * Send a POST request
     * @param url
     * @param data
     * @returns {Promise<Object>}
     */
     protected async put(url: string, data: any){
        return this.http.put(this.baseUrl + url, data, this.httpHeaders).pipe(
            tap({
                error: (error: any) => {
                    if (error.status === 500) {
                        // Handle 500
                    } else if (error.status === 400) {
                        // Handle 400
                    } else if (error.status === 401) {
                        // Handle 401
                    }
                }})).toPromise();
    }
       
    /**
     * Send a GET request
     * @param url
     * @returns {Promise<Object>}
     */
     protected async get(url: string): Promise<any>{
        return this.http.get(this.baseUrl + url, this.httpHeaders).pipe(
            tap({
                error: error => {
                    if (error.status === 500) {
                        // Handle 500
                    } else if (error.status === 400) {
                        // Handle 400
                    } else if (error.status === 401) {
                        // Handle 401
                    }
                }})).toPromise();
    }

    /**
     * Send a DELETE request
     * @param url
     * @returns {Promise<Object>}
     */
     protected async delete(url: string): Promise<any>{
        return this.http.delete(this.baseUrl + url, this.httpHeaders).pipe(
            tap({
                error: error => {
                    if (error.status === 500) {
                        // Handle 500
                    } else if (error.status === 400) {
                        // Handle 400
                    } else if (error.status === 401) {
                        // Handle 401
                    }
                }})).toPromise();
    }
       
}