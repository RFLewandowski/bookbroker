package com.nwo.libmanager.bookservice;

import com.nwo.libmanager.authorservice.AuthorService;
import com.nwo.libmanager.model.target.AuthorRating;
import com.nwo.libmanager.model.target.Book;
import com.nwo.libmanager.model.target.Library;
import com.nwo.libmanager.repository.DummyRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class AuthorServiceTest {//Authors are case sensitive

    @Autowired
    DummyRepository dummyRepository;
    @Autowired
    private AuthorService authorService;

    @Before
    public void setUp() throws Exception {
        Book book1 = new Book();
        book1.setAverageRating(2.3);
        book1.setAuthors(Collections.singletonList("Han Solo")); //solo author pun intended:D
        Book book2 = new Book();
        book2.setAverageRating(19.5);
        book2.setAuthors(Arrays.asList("Han Solo", "Luke Skywalker"));
        Book book3 = new Book();
        book3.setAverageRating(5.8);
        book3.setAuthors(Arrays.asList("Han Solo", "Luke Skywalker", "Chewbacca"));
        Library library = new Library();
        library.setBooks(Arrays.asList(book1, book2, book3));

        dummyRepository.setTestLibrary(library);
    }
    //Setup
    //book1 - Han Solo - avg Rating 2.3
    //book2 -Han Solo, Luke Skywalker 19.5
    //book3 - Han Solo, Luke Skywalker, Chewbacca 5.8
    //Expected Rating
    //AVG Rating - Luke Skywalker - 12.65 (rounded (up) to nearest 0.1)
    //AVG Rating - Han Solo - 9.2
    //AVG Rating - Chewbacca - 5.8

    @Test
    public void Should_CalculateRatings() throws Exception {
        //Given
        //
        //When
        List<AuthorRating> actualAuthorRatings = authorService.getAllAuthorsRatings();
        //Then
        assertEquals(
                "[AuthorRating(author=Luke Skywalker, averageRating=12.7), AuthorRating(author=Han Solo, averageRating=9.2), AuthorRating(author=Chewbacca, averageRating=5.8)]",
                actualAuthorRatings.toString());
    }

    @Test
    public void Should_NotCalculateRatings_WhenThereAreNoneGiven() throws Exception {
        //Given
        dummyRepository.setTestLibrary(new Library());
        //When
        List<AuthorRating> actualAuthorRatings = authorService.getAllAuthorsRatings();
        //Then
        assertEquals(new ArrayList<>(), actualAuthorRatings);
    }
}