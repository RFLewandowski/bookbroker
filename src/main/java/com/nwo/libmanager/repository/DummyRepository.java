package com.nwo.libmanager.repository;

import com.nwo.libmanager.model.source.Books;
import com.nwo.libmanager.model.target.Library;
import com.nwo.libmanager.bookservice.BooksConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class DummyRepository {
    @Value("${datasource}")
    private String jsonPath;
    private Library repoLibrary;

    @PostConstruct
    public void init() {//loads Json as in properties and Converts to book
        Books sourceBooks = SourceFileReader.readSource(jsonPath);
        repoLibrary = BooksConverter.convert(sourceBooks);
    }

    public Library getRepoLibrary() {
        return repoLibrary;
    }

    public void setTestSourcePatch(String testSourcePatch) {//loads specified Json and Converts to book
        Books sourceBooks = SourceFileReader.readSource(testSourcePatch);
        repoLibrary = BooksConverter.convert(sourceBooks);
    }

    public void setTestLibrary(Library repoLibrary) {
        this.repoLibrary = repoLibrary;
    }

}
