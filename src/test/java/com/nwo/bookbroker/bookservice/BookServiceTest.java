package com.nwo.bookbroker.bookservice;

import com.nwo.bookbroker.TestResourceManager;
import com.nwo.bookbroker.model.target.Book;
import com.nwo.bookbroker.repository.DummyRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class BookServiceTest {

    @Autowired
    private DummyRepository dummyRepository;
    @Autowired
    private BookService bookService;

    @Before
    public void setUp() throws Exception {
        String testJsonPath = TestResourceManager.getBigTestJsonPath();
        dummyRepository.setTestSourcePatch(testJsonPath);
    }

    @Test
    public void Should_GetBookByIsbn() throws Exception {
        //Given
        String validIsbn = "9781592432172";
        //When
        Optional<Book> book = bookService.getBookByIsbn(validIsbn);
        String actualTitle = book.get().getTitle();
        //Then
        assertEquals("A Hypervista of the Java Landscape", actualTitle);

    }

    @Test
    public void Should_GetBookByID_WhenNoValidISBN() throws Exception {//"gJEC2q7DzpQC"
        //Given
        String validId = "gJEC2q7DzpQC";
        //When
        Optional<Book> book = bookService.getBookByIsbn(validId);
        String actualTitle = book.get().getTitle();
        //Then
        assertEquals("The History of Java", actualTitle);
    }

    @Test
    public void Should_GetBooksByCategory() throws Exception {
        //Given
        String validCategory = "Computers";
        //When
        List<Book> books = bookService.getBooksByCategory(validCategory);
        String allCategoryBooks = books.toString();
        //Then
        assertEquals(TestResourceManager.getToStringOfComputerCategoryBooks(), allCategoryBooks);
    }

    @Test
    public void Should_ReturnEmptyList_When_NoSuchCategory() throws Exception {
        //Given
        String invalidCategory = "Gardening";
        //When
        List<Book> books = bookService.getBooksByCategory(invalidCategory);
        //Then
        assertEquals(new ArrayList<>(), books);
    }
}