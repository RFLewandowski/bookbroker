package com.nwo.libmanager.service;

import com.nwo.libmanager.model.source.Books;
import com.nwo.libmanager.model.target.Book;
import com.nwo.libmanager.model.target.Library;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BooksConverterTest {
    private static final String SMALL_TEST_JSON_PATH = "src/test/testResources/smallTestSource.json";
    private static final String BIG_TEST_JSON_PATH = "src/test/testResources/testSource.json";
    private static Books smallSourceBooks;
    private static Books bigSourceBooks;

    @BeforeClass
    public static void setUp() throws Exception {
        smallSourceBooks = SourceFileReader.readSource(SMALL_TEST_JSON_PATH);
        bigSourceBooks = SourceFileReader.readSource(BIG_TEST_JSON_PATH);
    }

    @Test
    public void Should_MatchToString_When_convertingSmallSource() throws Exception {
        //Given
        //Not most elegant way to test, but fast to write, and easy to interpret
        String expectedContent = "Book(isbn=9781592432172, title=A Hypervista of the Java Landscape, subtitle=, publisher=InfoStrategist.com, publishedDate=, description=, pageCount=null, thumbnailUrl=http://books.google.com/books/content?id=7tkN1CYzn2cC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api, language=en, previewLink=http://books.google.pl/books?id=7tkN1CYzn2cC&pg=PP1&dq=java&hl=&cd=1&source=gbs_api, averageRating=null, authors=[], categories=[])";
        //When
        Library library = BooksConverter.convert(smallSourceBooks);
        Book book = library.getBooks().get(0);
        //Then
        assertEquals(expectedContent, book.toString());
    }

    @Test
    public void Should_MatchToString_When_convertingBigSource() throws Exception {
        //Given
        //Not most elegant way to test, but fast to write, and easy to interpret
        String expectedContent = "Book(isbn=9780201310092, title=Concurrent Programming in Java, subtitle=Design Principles and Patterns, publisher=Addison-Wesley Professional, publishedDate=2000, description=Software -- Programming Languages., pageCount=411, thumbnailUrl=http://books.google.com/books/content?id=-x1S4neCSOYC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api, language=en, previewLink=http://books.google.pl/books?id=-x1S4neCSOYC&printsec=frontcover&dq=java&hl=&cd=19&source=gbs_api, averageRating=4.0, authors=[Douglas Lea], categories=[Computers])";
        //When
        Library library = BooksConverter.convert(bigSourceBooks);
        Book book = library.getBooks().get(18);
        //Then
        assertEquals(expectedContent, book.toString());
    }
}