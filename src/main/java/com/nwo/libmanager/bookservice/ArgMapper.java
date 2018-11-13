package com.nwo.libmanager.bookservice;


import com.nwo.libmanager.model.source.IndustryIdentifier;
import org.apache.logging.log4j.util.Strings;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Gets data from source and maps to equivalent appropriate for Book
 */
public class ArgMapper {

    private ArgMapper() {
    }

    /**
     * maps volumeInfo.industryIdentifiers "type": "ISBN_13"
     *
     * @param identifiers whole identifiers object containing ISBN_13, ISBN_10 or something else or nothing at all
     * @param recordId    id of item - book in source json
     * @return if no ISBN_13 id of the record will be used
     */
    public static String mapIsbn(List<IndustryIdentifier> identifiers, String recordId) {
        String isbn13IfExists = getIsbn13IfExists(identifiers);
        if (CollectionUtils.isEmpty(identifiers) || StringUtils.isEmpty(isbn13IfExists)) {
            return recordId;
        }
        return isbn13IfExists;
    }

    private static String getIsbn13IfExists(List<IndustryIdentifier> identifiers) {
        return
                Optional
                        .ofNullable(identifiers)
                        .orElseGet(Collections::emptyList)
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
            return Strings.EMPTY;
        }
        return sourceTitle;
    }

    /**
     * maps volumeInfo.subtitle
     */
    public static String mapSubtitle(String sourceSubtitle) {
        if (StringUtils.isEmpty(sourceSubtitle)) {
            return Strings.EMPTY;
        }
        return sourceSubtitle;
    }

    /**
     * maps volumeInfo.publisher
     */
    public static String mapPublisher(String sourcePublisher) {
        if (StringUtils.isEmpty(sourcePublisher)) {
            return Strings.EMPTY;
        }
        return sourcePublisher;
    }

    /**
     * maps volumeInfo.publishedDate
     * Unix timestamp can't be used - there are dates before 1970
     * , and this format seems quit unfitting for publication date.
     * String will be used instead due to various precisions and formats of dates in source file.
     */
    public static String mapPublishedDate(String sourceDate) {
        if (StringUtils.isEmpty(sourceDate)) {
            return Strings.EMPTY;
        }
        return sourceDate;
    }

    /**
     * maps volumeInfo.description
     */
    public static String mapDescription(String sourceDescription) {
        if (StringUtils.isEmpty(sourceDescription)) {
            return Strings.EMPTY;
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
            return Strings.EMPTY;
        }
        return sourceThumbnailUrl;
    }

    /**
     * maps volumeInfo.language
     */
    public static String mapLanguage(String sourceLanguage) {
        if (StringUtils.isEmpty(sourceLanguage)) {
            return Strings.EMPTY;
        }
        return sourceLanguage;
    }

    /**
     * maps volumeInfo.previewLink
     */
    public static String mapPreviewLink(String sourcePreviewLink) {
        if (StringUtils.isEmpty(sourcePreviewLink)) {
            return Strings.EMPTY;
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
