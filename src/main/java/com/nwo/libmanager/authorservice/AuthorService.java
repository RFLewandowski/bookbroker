package com.nwo.libmanager.authorservice;

import com.nwo.libmanager.model.target.AuthorRating;
import com.nwo.libmanager.repository.DummyRepository;
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
