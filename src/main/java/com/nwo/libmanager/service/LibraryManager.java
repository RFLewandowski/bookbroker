package com.nwo.libmanager.service;

import com.nwo.libmanager.model.source.Books;
import com.nwo.libmanager.model.target.Book;
import com.nwo.libmanager.model.target.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryManager {
    private final SourceFileReader sourceFileReader;
    private final BooksConverter booksConverter;

    private Library theLibrary;//state should not be in manager - to be moved to different place

    @Autowired
    public LibraryManager(SourceFileReader sourceFileReader, BooksConverter booksConverter) {
        this.sourceFileReader = sourceFileReader;
        this.booksConverter = booksConverter;
    }

    @PostConstruct
    public void init() {//loads Json and Converts to book
        String jsonPath = "src/test/testResources/smallTestSource.json";
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
}
