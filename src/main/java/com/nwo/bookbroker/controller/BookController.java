package com.nwo.bookbroker.controller;

import com.nwo.bookbroker.model.target.Book;
import com.nwo.bookbroker.bookservice.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
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

    @GetMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> getBooksByCategory(@RequestParam("categoryName") String categoryName) {
        return bookService.getBooksByCategory(categoryName);
    }
}
