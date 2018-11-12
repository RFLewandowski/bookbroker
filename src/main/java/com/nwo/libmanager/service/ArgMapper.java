package com.nwo.libmanager.service;


import com.nwo.libmanager.model.source.IndustryIdentifier;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Gets data from source and maps to equivalent appropriate for Book
 */
public class ArgMapper {

    private ArgMapper() {//noinstantiable utility class
    }

    /**
     * @param identifiers whole identifiers object containing ISBN_13, ISBN_10 or something else or nothing at all
     * @param recordId    id of item - book in source json
     * @return if no ISBN_13 id of the record will be used
     */
    public static String mapIsbn(List<IndustryIdentifier> identifiers, String recordId) {// volumeInfo.industryIdentifiers "type": "ISBN_13"
        String isbn13IfExists = getIsbn13IfExists(identifiers);
        if (CollectionUtils.isEmpty(identifiers) || StringUtils.isEmpty(isbn13IfExists)) {
            return recordId;
        }
        return isbn13IfExists;
    }

    private static String getIsbn13IfExists(List<IndustryIdentifier> identifiers) {
        return
                identifiers
                        .stream()
                        .filter(industryIdentifier -> industryIdentifier.getType().equals("ISBN_13"))
                        .map(IndustryIdentifier::getIdentifier)
                        .collect(Collectors.joining(","));
    }

    /**
     * maps volumeInfo.title
     */
    public static String mapTitle(String sourceTitle) {
        if (StringUtils.isEmpty(sourceTitle)) {
            return "";
        }
        return sourceTitle;
    }

    /**
     * maps volumeInfo.subtitle
     */
    public static String mapSubtitle(String sourceSubtitle) {
        if (StringUtils.isEmpty(sourceSubtitle)) {
            return "";
        }
        return sourceSubtitle;
    }

    /**
     * maps volumeInfo.publisher
     */
    public static String mapPublisher(String sourcePublisher) {
        if (StringUtils.isEmpty(sourcePublisher)) {
            return "";
        }
        return sourcePublisher;
    }

    /**
     * maps volumeInfo.publishedDate - string for now probably will be used Date or LoacalDate
     */
    public static String mapPublishedDate(String sourceDate) {
        if (StringUtils.isEmpty(sourceDate)) {
            return "";
        }
        return sourceDate;
    }

    /**
     * maps volumeInfo.description
     */
    public static String mapDescription(String sourceDescription) {
        if (StringUtils.isEmpty(sourceDescription)) {
            return "";
        }
        return sourceDescription;
    }

    /**
     * maps volumeInfo.pageCount
     */
    public static Integer mapPageCount(Integer sourcePageCount) {
        return sourcePageCount;
    }

    /**
     * maps volumeInfo.imageLinks.thumbnail
     */
    public static String mapThumbnailUrl(String sourceThumbnailUrl) {
        if (StringUtils.isEmpty(sourceThumbnailUrl)) {
            return "";
        }
        return sourceThumbnailUrl;
    }

    /**
     * maps volumeInfo.language
     */
    public static String mapLanguage(String sourceLanguage) {
        if (StringUtils.isEmpty(sourceLanguage)) {
            return "";
        }
        return sourceLanguage;
    }

    /**
     * maps volumeInfo.previewLink
     */
    public static String mapPreviewLink(String sourcePreviewLink) {
        if (StringUtils.isEmpty(sourcePreviewLink)) {
            return "";
        }
        return sourcePreviewLink;
    }

    /**
     * maps volumeInfo.averageRating
     */
    public static Double mapAverageRating(Double sourceAverageRating) {
        return sourceAverageRating;
    }

    /**
     * maps volumeInfo.authors
     */
    public static List<String> mapAuthors(List<String> sourceAuthors) {

        if (CollectionUtils.isEmpty(sourceAuthors)) {
            return new ArrayList<>();
        }
        return sourceAuthors;
    }

    /**
     * maps volumeInfo.categories
     */
    public static List<String> mapCategories(List<String> sourceCategories) {
        if (CollectionUtils.isEmpty(sourceCategories)) {
            return new ArrayList<>();
        }
        return sourceCategories;
    }
}
