package com.nwo.libmanager.bookservice;

import com.nwo.libmanager.model.source.IndustryIdentifier;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ArgMapperTest {

    private List<IndustryIdentifier> identifiers = new ArrayList<>();
    private String recordId = "validRecordID";

    @Test
    public void Should_returnISDN() throws Exception {
        //Given
        identifiers = Arrays.asList(
                new IndustryIdentifier("ISBN_13", "correctISBN13"),
                new IndustryIdentifier("someOtherIdentifier", "someOtherIdentifier"));
        //When
        String resultId = ArgMapper.mapIsbn(identifiers, recordId);
        //Then
        assertEquals("correctISBN13", resultId);
    }

    @Test
    public void Should_returnId_When_NoValidIdentifiers() throws Exception {
        //Given
        identifiers = Arrays.asList(new IndustryIdentifier("someOtherIdentifier", "someOtherIdentifier"));
        //When
        String resultId = ArgMapper.mapIsbn(identifiers, recordId);
        //Then
        assertEquals("validRecordID", resultId);
    }

    @Test
    public void Should_returnId_When_NoIdentifiers() throws Exception {
        //Given
        identifiers = null;
        //When
        String resultId = ArgMapper.mapIsbn(identifiers, recordId);
        //Then
        assertEquals("validRecordID", resultId);
    }

    @Test
    public void Should_returnNullAndNotCrash() throws Exception { //null is ok, converter will deal with it
        //Given
        identifiers = null;
        recordId = null;
        //When
        String resultId = ArgMapper.mapIsbn(identifiers, recordId);
        //Then
        assertEquals(null, resultId);
    }

}