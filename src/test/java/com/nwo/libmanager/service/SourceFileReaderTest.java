package com.nwo.libmanager.service;

import com.nwo.libmanager.model.source.Books;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SourceFileReaderTest {
    private static final String SMALL_TEST_JSON_PATH = "src/test/testResources/smallTestSource.json";
    private static final String BIG_TEST_JSON_PATH = "src/test/testResources/testSource.json";

    @Test
    public void Should_read_40_items() throws Exception {
        //Given
        //
        // When
        Books testBooks = SourceFileReader.readSource(BIG_TEST_JSON_PATH);
        int noOfTestItems = testBooks.getItems().size();
        //Then
        assertEquals(noOfTestItems, 40);
    }

    @Test
    public void Should_read_5_items() throws Exception {
        //Given
        //
        //When
        Books testBooks = SourceFileReader.readSource(SMALL_TEST_JSON_PATH);
        int noOfTestItems = testBooks.getItems().size();
        //Then
        assertEquals(noOfTestItems, 5);
    }
}