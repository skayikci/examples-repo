package com.example.searchautocomplete.search.service;

import com.example.searchautocomplete.search.model.Movie;
import com.example.searchautocomplete.search.model.SearchResult;
import com.example.searchautocomplete.search.repository.AutocompleteRepository;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AutocompleteServiceTest {

    @Mock
    AutocompleteRepository autocompleteRepository;

    @InjectMocks
    AutocompleteService autocompleteService;

    @Test
    void shouldExecuteSearch() {
        // given
        var param = "title";
        var movie = generateMovie("title", "2020-10-20");
        var serviceResult = SearchResult.builder().title(param).publishDate("2020-10-20").build();
        when(autocompleteRepository.findAllByTitle(param)).thenReturn(Flux.just(movie));

        // when
        var result = autocompleteService.autoCompleteSearch(param);

        // then
        StepVerifier.create(result)
                .expectSubscription()
                .assertNext(searchResult -> {
                    assertThat(searchResult, hasProperty("title", equalTo(serviceResult.getTitle())));
                    assertThat(searchResult, hasProperty("publishDate", equalTo(searchResult.getPublishDate())));
                })
                .expectComplete()
                .verify();
    }

    @Test
    void shouldReturnAtMostThreeResults() {
        // given
        var param = "title";
        var movies = generateMovies();
        when(autocompleteRepository.findAllByTitle(param)).thenReturn(movies);

        // when
        var result = autocompleteService.autoCompleteSearch(param);

        // then
        StepVerifier.create(result)
                .expectNextCount(3L)
                .expectComplete()
                .verify();

    }

    private Flux<Movie> generateMovies() {
        var movies = new ArrayList<Movie>();
        for (int i = 0; i < 10; i++) {
            movies.add(generateMovie("title" + i, "2020-10-20" + i));
        }
        return Flux.fromStream(movies.stream());
    }

    private Movie generateMovie(String title, String releaseDate) {
        var movie = new Movie();
        movie.setTitle(title);
        movie.setReleaseDate(releaseDate);
        return movie;
    }
}
