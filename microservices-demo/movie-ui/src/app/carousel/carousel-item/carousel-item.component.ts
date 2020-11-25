import {Component, OnInit} from '@angular/core';
import {NgbRatingConfig} from '@ng-bootstrap/ng-bootstrap';
import {Movie} from './movie';
import {Rating} from './rating';

@Component({
  selector: 'app-carousel-item',
  templateUrl: './carousel-item.component.html',
  styleUrls: ['./carousel-item.component.css']
})
export class CarouselItemComponent implements OnInit {
  currentRate = 0;
  movie: Movie;
  rating: Rating;

  constructor(config: NgbRatingConfig) {
    config.max = 5;
    this.movie = new Movie({
      name: 'test-name',
      releaseYear: '1986',
      producer: 'test-producer',
      director: 'test-director',
      imageUrl: ''
    } as Movie);
    this.rating = new Rating(
      {
        movieId: 'test-movie-id',
        movieRating: 3
      } as Rating);
    this.currentRate = this.rating.movieRating;
  }

  ngOnInit(): void {
  }

}
