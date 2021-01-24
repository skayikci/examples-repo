package com.example.movie.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "movie")
@Data
@Builder
public class Movie {
    @Id String id;
    String name;
    String director;
    String producer;
    String releaseYear;
}
