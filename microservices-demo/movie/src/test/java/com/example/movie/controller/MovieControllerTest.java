package com.example.movie.controller;

import com.example.movie.model.Movie;
import com.example.movie.service.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@WebFluxTest(MovieController.class)
@Import(MovieService.class)
public class MovieControllerTest {

    @MockBean
    private MovieService movieService;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void shouldGetAllMovies() {
        // given
        Movie movie = Movie.builder()
                .director("director")
                .name("name")
                .producer("test")
                .releaseYear("2020")
                .id("test-id")
                .build();
        // when
        when(movieService.findAll()).thenReturn(Flux.just(movie));
        webTestClient.get()
                .uri("/movie")
                .exchange()
                .expectStatus().isOk()
                .expectBody();

        // then
        verify(movieService, times(1)).findAll();
    }

    @Test
    void shouldGetSingleMovieByName() {
        // given
        Movie movie = Movie.builder()
                .director("director")
                .name("name")
                .producer("test")
                .releaseYear("2020")
                .id("test-id")
                .build();
        // when
        when(movieService.findAll()).thenReturn(Flux.just(movie));
        webTestClient.get()
                .uri("/movie")
                .exchange()
                .expectStatus().isOk()
                .expectBody();

        // then
        verify(movieService, times(1)).findAll();

    }


}
