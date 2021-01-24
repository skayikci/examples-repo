package com.example.searchautocomplete.search.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.List;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

/**
 * The movie model
 */
@Data
@Document(indexName = "tmdb")
public class Movies {
    @Id private String id;
    private String title;
    private String posterPath;
    private String overview;
    private String tagline;
    private List<String> directors;
    private String cast;
    @JsonProperty("release_date")
    @Field(name = "release_date")
    private String releaseDate;
    @JsonProperty("vote_average")
    @Field(name = "vote_average")
    private Long voteAverage;
    @JsonProperty("vote_count")
    @Field(name = "vote_count")
    private Long voteCount;
    private Long revenue;
}
