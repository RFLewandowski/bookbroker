package com.nwo.bookbroker.controller;

import com.nwo.bookbroker.authorservice.AuthorService;
import com.nwo.bookbroker.model.target.AuthorRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/library/author")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping(value = "/ratings", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AuthorRating> getAllAuthorsRatings() {
        return authorService.getAllAuthorsRatings();
    }
}
