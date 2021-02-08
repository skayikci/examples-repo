package com.example.searchautocomplete.search.controller;

import com.example.searchautocomplete.search.model.SearchResult;
import com.example.searchautocomplete.search.service.AutocompleteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = AutocompleteController.class)
class AutocompleteControllerTest {

    @MockBean
    public AutocompleteService autocompleteService;

    @Autowired
    public WebTestClient webTestClient;

    @Test
    void shouldWorkForGivenValue() {
        // given
        var param = "test";
        when(autocompleteService.autoCompleteSearch(param))
                .thenReturn(
                        Flux.just(SearchResult
                                .builder()
                                .title("title")
                                .publishDate("2020-10-20")
                                .build())
                );

        // when
        webTestClient.get()
                .uri("/autocomplete?term=" + param)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$[0].title").isNotEmpty()
                .jsonPath("$[0].publishDate").isEqualTo("2020-10-20");

        // then
        verify(autocompleteService).autoCompleteSearch(param);
    }

    @Test
    void shouldReturnEmptyResult() {
        // given
        var param = "test";
        when(autocompleteService.autoCompleteSearch(param)).thenReturn(Flux.empty());

        // when
        webTestClient.get()
                .uri("/autocomplete?term=" + param)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .json("[]");

        // then
        verify(autocompleteService).autoCompleteSearch(param);
    }
}
