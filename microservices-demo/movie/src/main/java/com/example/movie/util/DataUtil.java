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


        Movie movie = new Movie();
        movie.setDirector("Steven Spielberg");
        movie.setName("Jurassic Park");
        movie.setProducer("Warner Bros");
        movie.setReleaseYear("1993");



        movieRepository.save(movie);
    }
}
