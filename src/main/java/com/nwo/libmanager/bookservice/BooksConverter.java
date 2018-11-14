package com.nwo.libmanager.bookservice;

import com.nwo.libmanager.model.source.Books;
import com.nwo.libmanager.model.source.IndustryIdentifier;
import com.nwo.libmanager.model.source.Item;
import com.nwo.libmanager.model.source.VolumeInfo;
import com.nwo.libmanager.model.target.Book;
import com.nwo.libmanager.model.target.Library;

import java.util.List;

import static com.nwo.libmanager.bookservice.ArgMapper.*;

public class BooksConverter {

    private BooksConverter() {
    }

    /**
     * Converts source object gathered from JSON to collection of target books
     */
    public static Library convert(Books books) {
        Library library = new Library();
        List<Item> sourceBooks = books.getItems();

        for (Item sourceBook : sourceBooks) {
            List<IndustryIdentifier> identifiers = sourceBook.getVolumeInfo().getIndustryIdentifiers();
            VolumeInfo sourceVolumeInfo = sourceBook.getVolumeInfo();
            String sourceThumbnailUrl = sourceVolumeInfo.getImageLinks().getThumbnail();
            Book bookToAdd = Book
                    .builder()
                    .isbn(mapIsbn(identifiers, sourceBook.getId()))
                    .title(mapTitle(sourceVolumeInfo.getTitle()))
                    .subtitle(mapSubtitle(sourceVolumeInfo.getSubtitle()))
                    .publisher(mapPublisher(sourceVolumeInfo.getPublisher()))
                    .publishedDate(mapPublishedDate(sourceVolumeInfo.getPublishedDate()))
                    .description(mapDescription(sourceVolumeInfo.getDescription()))
                    .pageCount(mapPageCount(mapPageCount(sourceVolumeInfo.getPageCount())))
                    .thumbnailUrl(mapThumbnailUrl(sourceThumbnailUrl))
                    .language(mapLanguage(sourceVolumeInfo.getLanguage()))
                    .previewLink(mapPreviewLink(sourceVolumeInfo.getPreviewLink()))
                    .averageRating(mapAverageRating(sourceVolumeInfo.getAverageRating()))
                    .authors(mapAuthors(sourceVolumeInfo.getAuthors()))
                    .categories(mapCategories(sourceVolumeInfo.getCategories()))
                    .build();
            library.getBooks().add(bookToAdd);
        }
        return library;
    }
}
