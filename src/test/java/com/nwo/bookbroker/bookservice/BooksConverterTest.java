package com.nwo.bookbroker.bookservice;

import com.nwo.bookbroker.TestResourceManager;
import com.nwo.bookbroker.model.source.Books;
import com.nwo.bookbroker.model.target.Book;
import com.nwo.bookbroker.repository.Library;
import com.nwo.bookbroker.repository.SourceFileReader;
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