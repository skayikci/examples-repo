export class Rating {
  movieId: string;
  movieRating: number;

  constructor(rating: Rating) {
    this.movieId = rating.movieId;
    this.movieRating = rating.movieRating;
  }

}
