package com.nwo.libmanager.bookservice;

import com.nwo.libmanager.TestResourceManager;
import com.nwo.libmanager.model.source.Books;
import com.nwo.libmanager.model.target.Book;
import com.nwo.libmanager.model.target.Library;
import com.nwo.libmanager.repository.SourceFileReader;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BooksConverterTest {
    private static Books smallSourceBooks;
    private static Books bigSourceBooks;

    @BeforeClass
    public static void setUp() throws Exception {
        smallSourceBooks = SourceFileReader.readSource(TestResourceManager.getSmallTestJsonPath());
        bigSourceBooks = SourceFileReader.readSource(TestResourceManager.getBigTestJsonPath());
    }

    @Test
    public void Should_MatchToString_When_convertingSmallSource() throws Exception {
        //Given
        String expectedContent = TestResourceManager.getToStringOfConvertedSmallTest();
        //When
        Library library = BooksConverter.convert(smallSourceBooks);
        List<Book> books = library.getBooks();
        //Then
        assertEquals(expectedContent, books.toString());
    }

    @Test
    public void Should_MatchToString_When_convertingBigSource() throws Exception {
        //Given
        String expectedContent = TestResourceManager.getToStringOfConvertedBigTest();
        //When
        Library library = BooksConverter.convert(bigSourceBooks);
        List<Book> books = library.getBooks();
        //Then
        assertEquals(expectedContent, books.toString());
    }
}