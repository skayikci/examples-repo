package com.example.searchautocomplete.search.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Builder
@Data // needed for serialization, Bean resolver needs getter/setter
public class SearchResult implements Serializable {
    String title;
    Date publishDate;
}
