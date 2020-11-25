import { Injectable } from '@angular/core';
import {Movie} from '../../carousel/carousel-item/movie';
import {Observable, of} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminMoviesService {
  movies: Movie[] = [{name: 'test', releaseYear: '2015', producer: 'test', imageUrl: 'asd', director: 'asd', id: 'test-id'}];

  constructor() { }

  getMovies(): Observable<Movie[]> {
    return of(this.movies);
  }
}
