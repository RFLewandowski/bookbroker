package com.nwo.libmanager.bookservice;

import com.nwo.libmanager.TestResourceManager;
import com.nwo.libmanager.model.source.Books;
import com.nwo.libmanager.repository.SourceFileReader;
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