package com.example.searchautocomplete.search.repository;

import com.example.searchautocomplete.search.model.Movie;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;
import reactor.core.publisher.Flux;

public interface AutocompleteRepository extends ReactiveElasticsearchRepository<Movie, String> {

    /**
     * Find all by movie title
     */
    Flux<Movie> findAllByTitle(String title);

}
