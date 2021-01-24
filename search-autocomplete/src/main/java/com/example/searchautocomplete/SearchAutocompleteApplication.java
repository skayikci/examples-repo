package com.example.searchautocomplete;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Entry point for the app
 *
 * @author serhatkayikci
 */
@ComponentScan({"com.example.searchautocomplete.config","com.example.searchautocomplete.search"})
@SpringBootApplication
public class SearchAutocompleteApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchAutocompleteApplication.class, args);
	}

}
