package com.nwo.libmanager.service;

import com.nwo.libmanager.model.source.Books;
import com.nwo.libmanager.model.target.AuthorRating;
import com.nwo.libmanager.model.target.Book;
import com.nwo.libmanager.model.target.Library;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryManager {
    private Library theLibrary;//TODO state should not be in manager - to be moved to different place
    @Value("${datasource}")
    private String jsonPath;

    @PostConstruct
    public void init() {//loads Json as in properties and Converts to book
        Books sourceBooks = SourceFileReader.readSource(jsonPath);
        theLibrary = BooksConverter.convert(sourceBooks);
    }

    public void testInit(String testSourcePatch) {//loads specified Json and Converts to book
        Books sourceBooks = SourceFileReader.readSource(testSourcePatch);
        theLibrary = BooksConverter.convert(sourceBooks);
    }

    public Book getBookByIsbn(String isbn) {
        List<Book> foundBooks = theLibrary
                .getBooks()
                .stream()
                .filter(book -> isbn.equals(book.getIsbn()))
                .collect(Collectors.toList());
        if (CollectionUtils.isEmpty(foundBooks)) {
            return new Book();
        }
        return foundBooks.get(0);//assuming no more than one book will have specified id
    }

    public List<Book> getBooksByCategory(String categoryName) {
        return theLibrary
                .getBooks()
                .stream()
                .filter(book -> book.getCategories().contains(categoryName))
                .collect(Collectors.toList());
    }

    public List<AuthorRating> getAllAuthorsRatings() {
        return RatingCalculator.calculate(theLibrary);
    }


    public void setTestLibrary(Library theLibrary) {
        this.theLibrary = theLibrary;
    }
}
