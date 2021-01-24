package com.example.searchautocomplete.search.controller;

import com.example.searchautocomplete.search.service.AutocompleteService;
import com.example.searchautocomplete.search.model.SearchResult;
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
        return autocompleteService.autoCompleteSearch(term);
    }
}
