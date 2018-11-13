package com.nwo.libmanager.controller;

import com.nwo.libmanager.model.target.AuthorRating;
import com.nwo.libmanager.service.LibraryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AuthorController {

    private final LibraryManager libraryManager;

    @Autowired
    public AuthorController(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
    }

    @GetMapping(value = "/rating", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AuthorRating> getAllAuthorsRatings() {
        return libraryManager.getAllAuthorsRatings();
    }
}
