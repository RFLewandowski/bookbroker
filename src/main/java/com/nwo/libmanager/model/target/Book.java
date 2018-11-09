package com.nwo.libmanager.model.target;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "isbn",
        "title",
        "subtitle",
        "publisher",
        "publishedDate",
        "description",
        "pageCount",
        "thumbnailUrl",
        "language",
        "previewLink",
        "averageRating",
        "authors",
        "categories"
})
public class Book {
    @JsonProperty("isbn")
    private String isbn;
    @JsonProperty("title")
    private String title;
    @JsonProperty("subtitle")
    private String subtitle;
    @JsonProperty("publisher")
    private String publisher;
    @JsonProperty("publishedDate")
    private Integer publishedDate;
    @JsonProperty("description")
    private String description;
    @JsonProperty("pageCount")
    private Integer pageCount;
    @JsonProperty("thumbnailUrl")
    private String thumbnailUrl;
    @JsonProperty("language")
    private String language;
    @JsonProperty("previewLink")
    private String previewLink;
    @JsonProperty("averageRating")
    private Double averageRating;
    @JsonProperty("authors")
    private List<String> authors;
    @JsonProperty("categories")
    private List<String> categories;
}