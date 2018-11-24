package com.nwo.bookbroker.authorservice;

import com.nwo.bookbroker.model.target.AuthorRating;
import com.nwo.bookbroker.repository.DummyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final DummyRepository dummyRepository;

    @Autowired
    public AuthorService(DummyRepository dummyRepository) {
        this.dummyRepository = dummyRepository;
    }

    public List<AuthorRating> getAllAuthorsRatings() {
        return RatingCalculator.calculate(dummyRepository.getRepoLibrary());
    }
}
