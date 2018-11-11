package com.nwo.libmanager.service;

import com.nwo.libmanager.model.target.AuthorRating;
import com.nwo.libmanager.model.target.Book;
import com.nwo.libmanager.model.target.Library;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LibraryManagerTest {//Authors are case sensitive
    private LibraryManager libraryManager;

    private Library library;

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
        library = new Library();
        library.setBooksFromLibrary(Arrays.asList(book1, book2, book3));
    }
    //Setup

    //book1 - Han Solo - avg Rating 2.3
    //book2 -Han Solo, Luke Skywalker 19.5
    //book3 - Han Solo, Luke Skywalker, Chewbacca 5.8

    //AVG Rating - Luke Skywalker - 12.65
    //AVG Rating - Han Solo - 9.2
    //AVG Rating - Chewbacca - 5.8


    @Test
    public void Should_CalculateRatings() throws Exception {
        //Given
        libraryManager = new LibraryManager();
        libraryManager.setTestLibrary(library);
        //When
        List<AuthorRating> actualAuthorRatings = libraryManager.getAllAuthorsRatings();
        //Then
        assertEquals(
                "[AuthorRating(author=Luke Skywalker, averageRating=12.7), AuthorRating(author=Han Solo, averageRating=9.2), AuthorRating(author=Chewbacca, averageRating=5.8)]",
                actualAuthorRatings.toString());
    }
}