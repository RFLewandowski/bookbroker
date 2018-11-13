package com.nwo.libmanager.service;

import com.nwo.libmanager.model.target.AuthorRating;
import com.nwo.libmanager.model.target.Book;
import com.nwo.libmanager.repository.DummyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LibraryManager {

    private final DummyRepository dummyRepository;

    @Autowired
    public LibraryManager(DummyRepository dummyRepository) {
        this.dummyRepository = dummyRepository;
    }

    public Optional<Book> getBookByIsbn(String isbn) {
        return dummyRepository
                .getRepoLibrary()
                .getBooks()
                .stream()
                .filter(book -> isbn.equals(book.getIsbn()))
                .findFirst();


//                .getBooks()
//                .stream()
//                .filter(book -> isbn.equals(book.getIsbn()))
//                .collect(Collectors.toList());
//        if (CollectionUtils.isEmpty(foundBooks)) {
//            return new Book();
//        }
//        return foundBooks.get(0);//assuming no more than one book will have specified ISBN/id
    }

    public List<Book> getBooksByCategory(String categoryName) {
        return dummyRepository.getRepoLibrary()
                .getBooks()
                .stream()
                .filter(book -> book.getCategories().contains(categoryName))
                .collect(Collectors.toList());
    }

    public List<AuthorRating> getAllAuthorsRatings() {
        return RatingCalculator.calculate(dummyRepository.getRepoLibrary());
    }


}
