package com.nwo.libmanager.model.target;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
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
    private String isbn; //default ""
    @JsonProperty("title")
    private String title;
    @JsonProperty("subtitle")
    private String subtitle;
    @JsonProperty("publisher")
    private String publisher;
    //unix timestamp can't be used - as dates are not used for processing will be String for now
    @JsonProperty("publishedDate")
    private String publishedDate;
    @JsonProperty("description")
    private String description;
    @JsonProperty("pageCount")
    private Integer pageCount; //default null - to please json ignore
    @JsonProperty("thumbnailUrl")
    private String thumbnailUrl;
    @JsonProperty("language")
    private String language;
    @JsonProperty("previewLink")
    private String previewLink;
    @JsonProperty("averageRating")
    private Double averageRating; //default null - to please json ignore
    @JsonProperty("authors")
    private List<String> authors;
    @JsonProperty("categories")
    private List<String> categories;
}