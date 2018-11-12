package com.nwo.libmanager.repository;

import com.nwo.libmanager.model.source.Books;
import com.nwo.libmanager.model.target.Library;
import com.nwo.libmanager.service.BooksConverter;
import com.nwo.libmanager.service.SourceFileReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class DummyRepository {
    @Value("${datasource}")
    private String jsonPath;
    private Library theLibrary;

    @PostConstruct
    public void init() {//loads Json as in properties and Converts to book
        Books sourceBooks = SourceFileReader.readSource(jsonPath);
        theLibrary = BooksConverter.convert(sourceBooks);
    }

    public Library getTheLibrary() {
        return theLibrary;
    }

    public void setTestSourcePatch(String testSourcePatch) {//loads specified Json and Converts to book
        Books sourceBooks = SourceFileReader.readSource(testSourcePatch);
        theLibrary = BooksConverter.convert(sourceBooks);
    }

    public void setTestLibrary(Library theLibrary) {
        this.theLibrary = theLibrary;
    }

}
