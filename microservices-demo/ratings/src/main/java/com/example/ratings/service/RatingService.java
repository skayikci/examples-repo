package com.example.ratings.service;

import com.example.ratings.model.Rating;
import com.example.ratings.repository.RatingRepository;
import com.example.ratings.util.MovieRating;
import com.example.ratings.util.RatingCalculator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RatingService {

    private final RatingRepository ratingRepository;
    private final RatingCalculator ratingCalculator;


    public Mono<Rating> save(Rating rating) {
        return ratingRepository.save(rating);
    }

    public Flux<Rating> findAll() {
        return ratingRepository.findAll();
    }

    public Flux<Rating> findAllByMovie(String movieId) {
        return ratingRepository.findAllByMovieId(movieId);
    }

    public Mono<MovieRating> getSingleMovieRating(String movieId) {
        return ratingCalculator.calculateRatingForMovie(movieId);
    }
}
