package com.example.searchautocomplete.search.service;

import com.example.searchautocomplete.search.model.Movie;
import com.example.searchautocomplete.search.model.SearchResult;
import com.example.searchautocomplete.search.repository.AutocompleteRepository;
import com.example.searchautocomplete.util.StringToDateConverter;
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
                .map(this::mapTo)
                .sort((o1, o2) -> o2.getPublishDate().compareTo(o1.getPublishDate()));
    }

    private SearchResult mapTo(Movie allByTitle) {
        return SearchResult.builder()
                .publishDate(StringToDateConverter.convertStringToDate(allByTitle.getReleaseDate()))
                .title(allByTitle.getTitle())
                .build();
    }
}
