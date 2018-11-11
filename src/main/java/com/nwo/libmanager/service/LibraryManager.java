package com.nwo.libmanager.service;

import com.nwo.libmanager.model.source.Books;
import com.nwo.libmanager.model.target.AuthorRating;
import com.nwo.libmanager.model.target.Book;
import com.nwo.libmanager.model.target.Library;
import com.nwo.libmanager.model.target.RatingOverBooksNo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class LibraryManager {
    private Library theLibrary;//TODO state should not be in manager - to be moved to different place
    @Value("${datasource}")
    private String jsonPath;

    @PostConstruct
    public void init() {//loads Json and Converts to book
        Books sourceBooks = SourceFileReader.readSource(jsonPath);
        theLibrary = BooksConverter.convert(sourceBooks);
    }

    public Book getBookByIsbn(String isbn) {
        List<Book> foundBooks = theLibrary
                .getBooksFromLibrary()
                .stream()
                .filter(book -> isbn.equals(book.getIsbn()))
                .collect(Collectors.toList());
        if (CollectionUtils.isEmpty(foundBooks)) {
            return new Book();
        }
        return foundBooks.get(0);//assuming no more than one book will have specified id
    }

    public void testInit(String testSourcePatch) {//loads Json and Converts to book
        Books sourceBooks = SourceFileReader.readSource(testSourcePatch);
        theLibrary = BooksConverter.convert(sourceBooks);
    }

    public List<Book> getBooksByCategory(String categoryName) {
        return theLibrary
                .getBooksFromLibrary()
                .stream()
                .filter(book -> book.getCategories().contains(categoryName))
                .collect(Collectors.toList());
    }

    public List<AuthorRating> getAllAuthorsRatings() {
        List<Book> booksWithRatingAndAuthor = theLibrary
                .getBooksFromLibrary()
                .stream()
                .filter(book -> null != book.getAverageRating())
                .filter(book -> !CollectionUtils.isEmpty(book.getAuthors()))
                .collect(Collectors.toList());

        Map<String, RatingOverBooksNo> authorToSummaryRatingOverNoOfBooks = new LinkedHashMap<>();//contains value


        for (Book book : booksWithRatingAndAuthor) {//iterate over books
            for (String author : book.getAuthors()) {//iterate over Authors
                if (!authorToSummaryRatingOverNoOfBooks.containsKey(author)) {//add new author and current rating of his book
                    //System.out.println("adding:" +author);
                    RatingOverBooksNo newRating = new RatingOverBooksNo();
                    newRating.setForNewAuthor(book.getAverageRating());
                    authorToSummaryRatingOverNoOfBooks.put(author, newRating);
                } else {

                    Integer updatedNoOfBooks = authorToSummaryRatingOverNoOfBooks.get(author).getNoOfBooks() + 1;
                    authorToSummaryRatingOverNoOfBooks.get(author).setNoOfBooks(updatedNoOfBooks);

                    Double CurrentSummaryRating = authorToSummaryRatingOverNoOfBooks.get(author).getSumRating();
                    Double UpdatedSummaryRating = CurrentSummaryRating + book.getAverageRating();
                    authorToSummaryRatingOverNoOfBooks.get(author).setSumRating(UpdatedSummaryRating);
                }
            }
        }

        //mapper - from map to list of authors
        List<AuthorRating> result = new ArrayList<>();
        for (Map.Entry<String, RatingOverBooksNo> authorToSummaryRatingOverNoOfBook
                : authorToSummaryRatingOverNoOfBooks.entrySet()) {
            String author = authorToSummaryRatingOverNoOfBook.getKey();
            Double finalRating = authorToSummaryRatingOverNoOfBook.getValue().getFinalRating();

            Double truncatedFinalRating = BigDecimal.valueOf(finalRating) //set scale
                    .setScale(1, RoundingMode.HALF_UP)
                    .doubleValue();

            AuthorRating authorRating = new AuthorRating(author, truncatedFinalRating);
            result.add(authorRating);
        }
        //sort list ->ratings in descending order
        result.sort(Comparator.comparing(AuthorRating::getAverageRating, Comparator.reverseOrder()));
        return result;
    }

    public void setTestLibrary(Library theLibrary) {
        this.theLibrary = theLibrary;
    }
}
