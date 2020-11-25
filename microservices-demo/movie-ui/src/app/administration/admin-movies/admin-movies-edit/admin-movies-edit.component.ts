import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {Movie} from '../../../carousel/carousel-item/movie';

@Component({
  selector: 'app-admin-movies-edit',
  templateUrl: './admin-movies-edit.component.html',
  styleUrls: ['./admin-movies-edit.component.css']
})
export class AdminMoviesEditComponent implements OnInit {
  movieToEdit: Movie;

  constructor(private router: Router) {
    console.log('>>state', this.router.getCurrentNavigation());
    console.log('>>state', this.router.getCurrentNavigation().extras.state);
    this.movieToEdit = this.router.getCurrentNavigation().extras.state as Movie;
  }

  ngOnInit(): void {

  }

  save(movieToEdit: Movie): void {
    console.log(movieToEdit);
    this.router.navigateByUrl('/admin');
  }
}
