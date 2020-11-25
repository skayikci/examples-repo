package com.example.movie.service;

import com.example.movie.model.Movie;
import com.example.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public Mono<Movie> save(Movie movie) {
        movieRepository
                .findByNameAndDirectorAndReleaseYear(movie.getName(),
                        movie.getDirector(),
                        movie.getReleaseYear())
                ;
        return movieRepository.save(movie);
    }

    public Flux<Movie> findAll() {
        return movieRepository.findAll();
    }

}
