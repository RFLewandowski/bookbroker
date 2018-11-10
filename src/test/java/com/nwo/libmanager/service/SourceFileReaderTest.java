package com.nwo.libmanager.service;

import com.nwo.libmanager.model.source.Books;
import org.junit.Test;
import static org.junit.Assert.*;

public class SourceFileReaderTest {
    @Test
    public void Should_read_40_items() throws Exception {
        //Given
        String bigTestJsonPath = "src/test/testResources/testSource.json";
        //When
        Books testBooks = SourceFileReader.readSource(bigTestJsonPath);
        int noOfTestItems = testBooks.getItems().size();
        //Then
        assertEquals(noOfTestItems,40);
    }

    @Test
    public void Should_read_5_items() throws Exception {
        //Given
        String bigTestJsonPath = "src/test/testResources/smallTestSource.json";
        //When
        Books testBooks = SourceFileReader.readSource(bigTestJsonPath);
        int noOfTestItems = testBooks.getItems().size();
        //Then
        assertEquals(noOfTestItems,5);
    }

}