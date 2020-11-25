package com.example.ratings.controller;

import com.example.ratings.model.Rating;
import com.example.ratings.service.RatingService;
import com.example.ratings.util.MovieRating;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/rating")
@RequiredArgsConstructor
public class RatingController {

    private final RatingService ratingService;

    @PostMapping
    public Mono<ResponseEntity<Rating>> create(@RequestBody Rating rating) {
        return ratingService.save(rating).map(ResponseEntity::ok);
    }

    /**
     * Get the list of all ratings for a certain movie
     * @param movieId id of the movie id to get the ratings of
     * @return flux of all ratings
     */
    @GetMapping("/list/{movieId}")
    public Flux<Rating> listRatingsByMovieId(@PathVariable String movieId) {
        return ratingService.findAllByMovie(movieId);
    }

    /**
     * Get ratings
     * @param movieId id of the movie id to get the ratings of
     * @return flux of all ratings
     */
    @GetMapping("/{movieId}")
    public Mono<MovieRating> getSingleMovieRating(@PathVariable String movieId) {
        return ratingService.getSingleMovieRating(movieId);
    }
}
