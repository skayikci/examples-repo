package com.example.searchautocomplete.search.controller;

import com.example.searchautocomplete.search.service.AutocompleteService;
import com.example.searchautocomplete.search.model.SearchResult;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@RequestMapping("/autocomplete")
@RestController
class AutocompleteController {

    private final AutocompleteService autocompleteService;

    //todo: add pagination
    @GetMapping
    Flux<SearchResult> autoCompleteSearch(@Param("term") String term){
//        return autocompleteService.autoCompleteSearch(term);
        return Flux.fromStream(this::searchResultStream);
    }

    private Stream<SearchResult> searchResultStream() {
        List<SearchResult> searchResultList = new ArrayList<SearchResult>();
        searchResultList.add(SearchResult.builder().title("test1").build());
        searchResultList.add(SearchResult.builder().title("test2").build());
        searchResultList.add(SearchResult.builder().title("test3").build());
        searchResultList.add(SearchResult.builder().title("test4").build());
        searchResultList.add(SearchResult.builder().title("test5").build());
        searchResultList.add(SearchResult.builder().title("test6").build());
        searchResultList.add(SearchResult.builder().title("test7").build());
        searchResultList.add(SearchResult.builder().title("test8").build());
        return searchResultList.stream();
    }
}
