import {Injectable} from '@angular/core';
import {Observable, of} from 'rxjs';
import {Movie} from './movie';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  constructor() {
  }

  getSingleMovie$(movieId: string): Observable<Movie> {
    return of({name: 'test-name', director: 'test-director'} as Movie);
  }
}
