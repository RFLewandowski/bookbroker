package com.nwo.libmanager.service;

import com.nwo.libmanager.model.target.AuthorRating;
import com.nwo.libmanager.model.target.Book;
import com.nwo.libmanager.model.target.Library;
import com.nwo.libmanager.model.target.Rating;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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

        return authorToSummaryRatingOverNoOfBooks
                .entrySet()
                .stream()
                .map(RatingCalculator::mapToAuthorRating)
                .sorted(Comparator.comparing(AuthorRating::getAverageRating, Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }


    private static AuthorRating mapToAuthorRating(Map.Entry<String, Rating> entry) {
        String author = entry.getKey();
        Double rating = entry.getValue().getRating();
        return new AuthorRating(author, setResultScale(rating));
    }

    private static Double setResultScale(Double rating) {
        return BigDecimal.valueOf(rating)
                .setScale(1, RoundingMode.HALF_UP)
                .doubleValue();
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
