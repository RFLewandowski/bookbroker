package com.nwo.libmanager.service;

import com.nwo.libmanager.model.target.AuthorRating;
import com.nwo.libmanager.model.target.Book;
import com.nwo.libmanager.model.target.Library;
import com.nwo.libmanager.model.target.RatingOverBooksNo;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class RatingCalculator {

    private RatingCalculator() {//noinstantiable utility class
    }

    public static List<AuthorRating> calculate(Library theLibrary) {
        List<Book> booksWithRatingAndAuthor = fiterOutEmptyAuthorsAndRatings(theLibrary);
        Map<String, RatingOverBooksNo> authorToSummaryRatingOverNoOfBooks = new LinkedHashMap<>();//contains value

        for (Book book : booksWithRatingAndAuthor) {//iterate over books
            for (String author : book.getAuthors()) {//iterate over Authors
                if (!authorToSummaryRatingOverNoOfBooks.containsKey(author)) {//add new author and current rating of his book
                    //System.out.println("adding:" +author);
                    RatingOverBooksNo newRating = new RatingOverBooksNo(book.getAverageRating());
                    authorToSummaryRatingOverNoOfBooks.put(author, newRating);
                } else {
                    //Integer updatedNoOfBooks = authorToSummaryRatingOverNoOfBooks.get(author).getNoOfBooks() + 1;
                    //authorToSummaryRatingOverNoOfBooks.get(author).setNoOfBooks(updatedNoOfBooks);

                    RatingOverBooksNo rating = authorToSummaryRatingOverNoOfBooks.get(author);
                    authorToSummaryRatingOverNoOfBooks.get(author).updateRating(book.getAverageRating());
                }
            }
        }

        //mapper - from map to list of authors
        List<AuthorRating> result = new ArrayList<>();
        for (Map.Entry<String, RatingOverBooksNo> authorToSummaryRatingOverNoOfBook
                : authorToSummaryRatingOverNoOfBooks.entrySet()) {
            String author = authorToSummaryRatingOverNoOfBook.getKey();
            Double finalRating = authorToSummaryRatingOverNoOfBook.getValue().getRating();

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

    private static List<Book> fiterOutEmptyAuthorsAndRatings(Library library) {
        return library
                .getBooks()
                .stream()
                .filter(book -> null != book.getAverageRating())
                .filter(book -> !CollectionUtils.isEmpty(book.getAuthors()))
                .collect(Collectors.toList());
    }
}
