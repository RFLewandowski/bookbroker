package com.nwo.libmanager.service;


import com.nwo.libmanager.model.source.IndustryIdentifier;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * gets data from source and maps to equivalent appropriate for Book
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


    public static String mapTitle(String sourceTitle) {//volumeInfo.title
        if (StringUtils.isEmpty(sourceTitle)) {
            return "";
        }
        return sourceTitle;
    }

    public static String mapSubtitle(String sourceSubtitle) {//volumeInfo.subtitle
        if (StringUtils.isEmpty(sourceSubtitle)) {
            return "";
        }
        return sourceSubtitle;
    }

    public static String mapPublisher(String sourcePublisher) { //volumeInfo.publisher
        if (StringUtils.isEmpty(sourcePublisher)) {
            return "";
        }
        return sourcePublisher;
    }

    public static String mapPublishedDate(String sourceDate) {//volumeInfo.publishedDate - string for now probably will be used Date or LoacalDate
        if (StringUtils.isEmpty(sourceDate)) {
            return "";
        }
        return sourceDate;
    }

    public static String mapDescription(String sourceDescription) {//volumeInfo.description
        if (StringUtils.isEmpty(sourceDescription)) {
            return "";
        }
        return sourceDescription;
    }

    public static Integer mapPageCount(Integer sourcePageCount) {//volumeInfo.pageCount
        return sourcePageCount;
    }

    public static String mapThumbnailUrl(String sourceThumbnailUrl) {//volumeInfo.imageLinks.thumbnail
        if (StringUtils.isEmpty(sourceThumbnailUrl)) {
            return "";
        }
        return sourceThumbnailUrl;
    }

    public static String mapLanguage(String sourceLanguage) { //volumeInfo.language
        if (StringUtils.isEmpty(sourceLanguage)) {
            return "";
        }
        return sourceLanguage;
    }

    public static String mapPreviewLink(String sourcePreviewLink) {//volumeInfo.previewLink
        if (StringUtils.isEmpty(sourcePreviewLink)) {
            return "";
        }
        return sourcePreviewLink;
    }

    public static Double mapAverageRating(Double sourceAverageRating) { //volumeInfo.averageRating
        return sourceAverageRating;
    }

    public static List<String> mapAuthors(List<String> sourceAuthors) {//volumeInfo.authors

        if (CollectionUtils.isEmpty(sourceAuthors)) {
            return new ArrayList<>();
        }
        return sourceAuthors;
    }

    public static List<String> mapCategories(List<String> sourceCategories) {//volumeInfo.categories
        if (CollectionUtils.isEmpty(sourceCategories)) {
            return new ArrayList<>();
        }
        return sourceCategories;
    }
}
