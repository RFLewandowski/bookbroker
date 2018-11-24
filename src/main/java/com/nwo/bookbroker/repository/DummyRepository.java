package com.nwo.bookbroker.repository;

import com.nwo.bookbroker.model.source.Books;
import com.nwo.bookbroker.bookservice.BooksConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class DummyRepository {
    @Value("${datasource}")
    private String jsonPath;
    private Library repoLibrary;

    @PostConstruct
    public void init() {//loads Json as in properties and converts to book
        Books sourceBooks = SourceFileReader.readSource(jsonPath);
        repoLibrary = BooksConverter.convert(sourceBooks);
    }

    public Library getRepoLibrary() {
        return repoLibrary;
    }

    public void setTestSourcePatch(String testSourcePatch) {//loads specified Json and converts to book
        Books sourceBooks = SourceFileReader.readSource(testSourcePatch);
        repoLibrary = BooksConverter.convert(sourceBooks);
    }

    public void setTestLibrary(Library repoLibrary) {
        this.repoLibrary = repoLibrary;
    }

}
