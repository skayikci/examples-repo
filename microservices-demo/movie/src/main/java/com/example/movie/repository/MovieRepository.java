package com.example.movie.repository;

import com.example.movie.model.Movie;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface MovieRepository extends ReactiveCrudRepository<Movie, String> {
    Mono<Movie> findByNameAndDirectorAndReleaseYear(String name, String director, String releaseYear);
}
