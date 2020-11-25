import {Component, OnInit} from '@angular/core';
import {AdminMoviesService} from './admin-movies.service';
import {Movie} from '../../carousel/carousel-item/movie';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-admin-movies',
  templateUrl: './admin-movies.component.html',
  styleUrls: ['./admin-movies.component.css']
})
export class AdminMoviesComponent implements OnInit {
  movies$: Observable<Movie[]>;

  constructor(private adminMoviesService: AdminMoviesService) {
  }

  ngOnInit(): void {
    this.movies$ = this.getMovies();
  }

  getMovies(): Observable<Movie[]> {
    return this.adminMoviesService.getMovies();
  }

}
