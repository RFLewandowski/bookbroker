
package com.nwo.bookbroker.model.source;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "title",
        "publisher",
        "industryIdentifiers",
        "readingModes",
        "printType",
        "maturityRating",
        "allowAnonLogging",
        "contentVersion",
        "imageLinks",
        "language",
        "previewLink",
        "infoLink",
        "canonicalVolumeLink",
        "authors",
        "publishedDate",
        "description",
        "pageCount",
        "categories",
        "averageRating",
        "ratingsCount",
        "panelizationSummary",
        "subtitle"
})
public class VolumeInfo {
    @JsonProperty("title")
    private String title;
    @JsonProperty("publisher")
    private String publisher;
    @JsonProperty("industryIdentifiers")
    private List<IndustryIdentifier> industryIdentifiers = new ArrayList<>();
    @JsonProperty("readingModes")
    private ReadingModes readingModes;
    @JsonProperty("printType")
    private String printType;
    @JsonProperty("maturityRating")
    private String maturityRating;
    @JsonProperty("allowAnonLogging")
    private Boolean allowAnonLogging;
    @JsonProperty("contentVersion")
    private String contentVersion;
    @JsonProperty("imageLinks")
    private ImageLinks imageLinks;
    @JsonProperty("language")
    private String language;
    @JsonProperty("previewLink")
    private String previewLink;
    @JsonProperty("infoLink")
    private String infoLink;
    @JsonProperty("canonicalVolumeLink")
    private String canonicalVolumeLink;
    @JsonProperty("authors")
    private List<String> authors = new ArrayList<>();
    @JsonProperty("publishedDate")
    private String publishedDate;
    @JsonProperty("description")
    private String description;
    @JsonProperty("pageCount")
    private Integer pageCount;
    @JsonProperty("categories")
    private List<String> categories = new ArrayList<>();
    @JsonProperty("averageRating")
    private Double averageRating;
    @JsonProperty("ratingsCount")
    private Integer ratingsCount;
    @JsonProperty("panelizationSummary")
    private PanelizationSummary panelizationSummary;
    @JsonProperty("subtitle")
    private String subtitle;
}
