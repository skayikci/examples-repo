package com.example.ratings.util;

import com.example.ratings.model.Rating;
import com.example.ratings.repository.RatingRepository;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class RatingCalculator {
    private final RatingRepository ratingRepository;

    public Mono<MovieRating> calculateRatingForMovie(String movieId) {
        return ratingRepository
                .findAllByMovieId(movieId)
                .collect(Collectors.averagingInt(Rating::getRating))
                .map(resultRating -> new MovieRating(
                        resultRating.intValue(),
                        movieId
                ));
    }
}
