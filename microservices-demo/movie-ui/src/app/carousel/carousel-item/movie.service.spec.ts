import { TestBed } from '@angular/core/testing';

import { MovieService } from './movie.service';
import {Movie} from './movie';

describe('MovieService', () => {
  let service: MovieService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MovieService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should get a movie', done => {
    // given
    const movie = {name: 'test-name', director: 'test-director'} as Movie;
    // when
    const code$ = service.getSingleMovie$('test-name');

    code$.subscribe(
      code => {
        expect(code.name).toBe(movie.name);
        expect(code.director).toBe(movie.director);
        done();
      }
    );
  });
});
