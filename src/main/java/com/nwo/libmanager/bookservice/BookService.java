package com.nwo.libmanager.bookservice;

import com.nwo.libmanager.model.target.Book;
import com.nwo.libmanager.repository.DummyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final DummyRepository dummyRepository;

    @Autowired
    public BookService(DummyRepository dummyRepository) {
        this.dummyRepository = dummyRepository;
    }

    public Optional<Book> getBookByIsbn(String isbn) {
        return dummyRepository
                .getRepoLibrary()
                .getBooks()
                .stream()
                .filter(book -> isbn.equals(book.getIsbn()))
                .findFirst();
    }

    public List<Book> getBooksByCategory(String categoryName) {
        return dummyRepository.getRepoLibrary()
                .getBooks()
                .stream()
                .filter(book -> book.getCategories().contains(categoryName))
                .collect(Collectors.toList());
    }
}
