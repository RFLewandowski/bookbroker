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
        List<Book> booksWithRatingAndAuthor = filterOutEmptyAuthorsAndRatings(theLibrary);
        Map<String, Rating> authorToRating = getAuthorToRating(booksWithRatingAndAuthor);

        return authorToRating
                .entrySet()
                .stream()
                .map(RatingCalculator::entryToAuthorRating)
                .sorted(Comparator.comparing(AuthorRating::getAverageRating, Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }

    private static Map<String, Rating> getAuthorToRating(List<Book> books) {
        Map<String, Rating> authorToRating = new LinkedHashMap<>();
        for (Book book : books) {
            authorToRating = updateWithBook(authorToRating, book);//authorRating passed tis way because I don't want to have any (even static) fields in this class
        }
        return authorToRating;
    }

    private static Map<String, Rating> updateWithBook(Map<String, Rating> authorToRating, Book book) {
        for (String author : book.getAuthors()) {
            if (authorToRating.containsKey(author)) {
                authorToRating
                        .get(author)
                        .updateRating(book.getAverageRating());
            } else {
                Rating newRating = new Rating(book.getAverageRating());
                authorToRating.put(author, newRating);
            }
        }
        return authorToRating;
    }

    private static AuthorRating entryToAuthorRating(Map.Entry<String, Rating> entry) {
        String author = entry.getKey();
        Double rating = entry.getValue().getRating();
        return new AuthorRating(author, setResultScale(rating));
    }

    private static Double setResultScale(Double rating) {
        return BigDecimal.valueOf(rating)
                .setScale(1, RoundingMode.HALF_UP)
                .doubleValue();
    }

    private static List<Book> filterOutEmptyAuthorsAndRatings(Library library) {
        return library
                .getBooks()
                .stream()
                .filter(book -> null != book.getAverageRating())
                .filter(book -> !CollectionUtils.isEmpty(book.getAuthors()))
                .collect(Collectors.toList());
    }
}
