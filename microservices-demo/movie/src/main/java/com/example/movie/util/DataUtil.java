package com.example.movie.util;

import com.example.movie.model.Movie;
import com.example.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataUtil implements CommandLineRunner {
    private final MovieRepository movieRepository;

    @Override
    public void run(String... args) throws Exception {
        movieRepository.deleteAll();


        Movie movie = Movie.builder()
                .director("Steven Spielberg")
                .name("Jurassic Park")
                .producer("Warner Bros")
                .releaseYear("1993")
                .build();



        movieRepository.save(movie);
    }
}
