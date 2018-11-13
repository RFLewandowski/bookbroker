package com.nwo.libmanager.controller;

import com.nwo.libmanager.model.target.Book;
import com.nwo.libmanager.bookservice.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/book/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book getBookByIsbn(@PathVariable("isbn") String isbn) throws BookNotFoundException {
        return bookService.getBookByIsbn(isbn).orElseThrow(BookNotFoundException::new);
    }

    @GetMapping(value = "/category/{categoryName}/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> getBooksByCategory(@PathVariable("categoryName") String categoryName) {
        return bookService.getBooksByCategory(categoryName);
    }
}
