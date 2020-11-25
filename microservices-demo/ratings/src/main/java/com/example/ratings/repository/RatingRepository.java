package com.example.ratings.repository;

import com.example.ratings.model.Rating;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * Spring Data MongoDB reactive repository for the Article entity.
 *
 * @author dassiorleando
 */
@Repository
public interface RatingRepository extends ReactiveMongoRepository<Rating, String> {
    Flux<Rating> findAllByMovieId(String movieId);
}
