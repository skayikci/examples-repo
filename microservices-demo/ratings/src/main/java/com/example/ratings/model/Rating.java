package com.example.ratings.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "rating")
@Data
public class Rating {
    @Id
    private String id;
    private String movieId;
    private String userId;
    private Integer rating;
}
