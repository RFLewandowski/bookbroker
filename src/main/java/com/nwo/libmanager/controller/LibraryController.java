package com.nwo.libmanager.controller;

import com.nwo.libmanager.model.target.AuthorRating;
import com.nwo.libmanager.model.target.Book;
import com.nwo.libmanager.service.LibraryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LibraryController {

    private final LibraryManager libraryManager;

    @Autowired
    public LibraryController(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
    }

    @GetMapping(value = "/book/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book getBookByIsbn(@PathVariable("isbn") String isbn) throws BookNotFoundException {
        Book foundBook = libraryManager.getBookByIsbn(isbn);
        if (foundBook.equals(new Book())) {
            throw new BookNotFoundException();
        }
        return foundBook;
    }

    @GetMapping(value = "/category/{categoryName}/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> getBooksByCategory(@PathVariable("categoryName") String categoryName) {
        return libraryManager.getBooksByCategory(categoryName);
    }

    @GetMapping(value = "/rating", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AuthorRating> getAllAuthorsRatings() {
        return libraryManager.getAllAuthorsRatings();
    }

}
