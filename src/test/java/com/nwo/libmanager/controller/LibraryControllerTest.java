package com.nwo.libmanager.controller;

import com.nwo.libmanager.service.LibraryManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LibraryControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private LibraryManager libraryManager;
    private static final String SMALL_TEST_JSON_PATH = "src/test/testResources/smallTestSource.json";

    @Before
    public void setUp() throws Exception {
        libraryManager.testInit(SMALL_TEST_JSON_PATH);
    }

    @Test
    public void Should_GetBookByIsbn() throws Exception {
        this.mockMvc
                .perform(get("/api/book/9781592432172"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.title").value("A Hypervista of the Java Landscapeaaa"));
    }

    @Test
    public void Should_GetBookByIsbnWhichIsActuallyId() throws Exception {
        this.mockMvc
                .perform(get("/api/book/gJEC2q7DzpQC"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.title").value("The History of Java"));
    }

    @Test
    public void Should_NotFindBookSpecifiedWithIsbn() throws Exception {
        this.mockMvc
                .perform(get("/api/book/ThereIsNoSuchBook"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(status().reason(containsString("No results found")));
    }

    @Test
    public void Should_GetBooksByCategory() throws Exception {
        this.mockMvc
                .perform(get("/api/category/Religion/books"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.[0].title").value("The Religion of Java"));
    }

    @Test
    public void Should_CategoriesBeCaseSensitive_When_Getting() throws Exception {
        this.mockMvc
                .perform(get("/api/category/ReLigiOn/books"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().string("[]"));
    }

    @Test
    public void Should_ReturnEmpty_When_NoSuchCategory() throws Exception {
        this.mockMvc
                .perform(get("/api/category/NoSuchCategory/books"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().string("[]"));
    }

}