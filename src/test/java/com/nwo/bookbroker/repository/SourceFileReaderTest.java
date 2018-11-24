package com.nwo.bookbroker.repository;

import com.nwo.bookbroker.TestResourceManager;
import com.nwo.bookbroker.model.source.Books;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SourceFileReaderTest {

    @Test
    public void Should_read_40_items() throws Exception {
        //Given
        String testJsonPath = TestResourceManager.getBigTestJsonPath();
        // When
        Books testBooks = SourceFileReader.readSource(testJsonPath);
        int noOfTestItems = testBooks.getItems().size();
        //Then
        assertEquals(noOfTestItems, 40);
    }

    @Test
    public void Should_read_5_items() throws Exception {
        //Given
        String testJsonPath = TestResourceManager.getSmallTestJsonPath();
        //When
        Books testBooks = SourceFileReader.readSource(testJsonPath);
        int noOfTestItems = testBooks.getItems().size();
        //Then
        assertEquals(noOfTestItems, 5);
    }
}