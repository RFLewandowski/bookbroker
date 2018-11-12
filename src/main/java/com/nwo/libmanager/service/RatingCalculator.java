package com.nwo.libmanager.service;

import com.nwo.libmanager.model.target.AuthorRating;
import com.nwo.libmanager.model.target.Book;
import com.nwo.libmanager.model.target.Library;
import com.nwo.libmanager.model.target.Rating;
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
        Map<String, Rating> authorToSummaryRatingOverNoOfBooks = new LinkedHashMap<>();//contains value

        for (Book book : booksWithRatingAndAuthor) {//iterate over books
            for (String author : book.getAuthors()) {//iterate over Authors
                if (!authorToSummaryRatingOverNoOfBooks.containsKey(author)) {//add new author and current rating of his book
                    Rating newRating = new Rating(book.getAverageRating());
                    authorToSummaryRatingOverNoOfBooks.put(author, newRating);
                } else {
                    authorToSummaryRatingOverNoOfBooks
                            .get(author)
                            .updateRating(book.getAverageRating());
                }
            }
        }

        //mapper - from map to list of authors
        List<AuthorRating> result = new ArrayList<>();
        for (Map.Entry<String, Rating> authorToSummaryRatingOverNoOfBook
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
