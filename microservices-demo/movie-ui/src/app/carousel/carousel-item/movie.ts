/**
 * A movie model
 */
export class Movie {
  name: string;
  director: string;
  producer: string;
  releaseYear: string;
  imageUrl: string;
  id: string;

  constructor(movie: Movie) {
    this.name = movie.name;
    this.director = movie.director;
    this.producer = movie.producer;
    this.releaseYear = movie.releaseYear;
    this.imageUrl = movie.imageUrl;
    this.id = movie.id;
  }
}
