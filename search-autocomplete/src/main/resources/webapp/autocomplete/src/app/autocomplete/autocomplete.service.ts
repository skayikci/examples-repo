import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AutocompleteService {

  constructor(private http: HttpClient) { }

  getAutocompleteResult(query: string): Observable<any> {
    console.log(query);
    return this.http.get('http://localhost:8089/autocomplete?term='+query);
  }
}
