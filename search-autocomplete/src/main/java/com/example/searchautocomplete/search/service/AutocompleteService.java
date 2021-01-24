package com.example.searchautocomplete.search.service;

import com.example.searchautocomplete.search.model.Movies;
import com.example.searchautocomplete.search.model.SearchResult;
import com.example.searchautocomplete.search.repository.AutocompleteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Service
public class AutocompleteService {
    private final AutocompleteRepository autocompleteRepository;

    public Flux<SearchResult> autoCompleteSearch(String term) {
        //todo : add total result counts to the result
        return autocompleteRepository
                .findAllByTitle(term)
                .take(3L)
                .map(this::mapTo);
    }

    private SearchResult mapTo(Movies allByTitle) {
        return SearchResult.builder()
                .publishDate(allByTitle.getReleaseDate())
                .title(allByTitle.getTitle())
                .build();
    }
}
