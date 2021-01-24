package com.example.searchautocomplete.search.repository;

import com.example.searchautocomplete.search.model.Movies;
import com.example.searchautocomplete.search.model.SearchResult;
import com.example.searchautocomplete.search.service.AutocompleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

public interface AutocompleteRepository extends ReactiveElasticsearchRepository<Movies, String> {

    /**
     * Find all by movie title
     */
    Flux<Movies> findAllByTitle(String title);

}
