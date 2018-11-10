package com.nwo.libmanager.service;

import com.nwo.libmanager.model.source.Books;
import com.nwo.libmanager.model.source.IndustryIdentifier;
import com.nwo.libmanager.model.source.Item;
import com.nwo.libmanager.model.source.VolumeInfo;
import com.nwo.libmanager.model.target.Book;
import com.nwo.libmanager.model.target.Library;

import java.util.List;

import static com.nwo.libmanager.service.ArgMapper.*;


public class BooksConverter {

    /* Converts source object gatered from JSON to collection of target books
     */
    public static Library convert(Books books) {
        Library library = new Library();
        List<Item> sourceBooks = books.getItems();

        for (Item sourceBook : sourceBooks) {
            Book bookToAdd = new Book();



            List<IndustryIdentifier> identifiers = sourceBook.getVolumeInfo().getIndustryIdentifiers();
            String recordId = sourceBook.getId();
            bookToAdd.setIsbn(mapIsbn(identifiers, recordId));

            VolumeInfo sourceVolumeInfo = sourceBook.getVolumeInfo();

            String sourceTitle = sourceVolumeInfo.getTitle();
            bookToAdd.setTitle(mapTitle(sourceTitle));

            String sourceSubtitle = sourceVolumeInfo.getSubtitle();
            bookToAdd.setSubtitle(mapSubtitle(sourceSubtitle));

            String sourcePublisher = sourceVolumeInfo.getPublisher();
            bookToAdd.setPublisher(mapPublisher(sourcePublisher));

            String sourceDate = sourceVolumeInfo.getPublishedDate();
            bookToAdd.setPublishedDate(mapPublishedDate(sourceDate));

            String sourceDescription = sourceVolumeInfo.getDescription();
            bookToAdd.setDescription(mapDescription(sourceDescription));

            Integer sourcePageCount = sourceVolumeInfo.getPageCount();
            bookToAdd.setPageCount(mapPageCount(sourcePageCount));

            String sourceThumbnailUrl = sourceVolumeInfo.getImageLinks().getThumbnail();
            bookToAdd.setThumbnailUrl(mapThumbnailUrl(sourceThumbnailUrl));

            String sourceLanguage = sourceVolumeInfo.getLanguage();
            bookToAdd.setLanguage(mapLanguage(sourceLanguage));

            String sourcePrevieLink = sourceVolumeInfo.getPreviewLink();
            bookToAdd.setPreviewLink(mapPreviewLink(sourcePrevieLink));

            Double sourceAverageRating = sourceVolumeInfo.getAverageRating();
            bookToAdd.setAverageRating(mapAverageRating(sourceAverageRating));

            List<String> sourceAuthors = sourceVolumeInfo.getAuthors();
            bookToAdd.setAuthors(mapAuthors(sourceAuthors));

            List<String> sourceCategories = sourceVolumeInfo.getCategories();
            bookToAdd.setCategories(mapCategories(sourceCategories));

            library.getBooksFromLibrary().add(bookToAdd);
        }
        return library;
    }
}
