package com.nwo.libmanager.controller;

import com.nwo.libmanager.TestResourceManager;
import com.nwo.libmanager.repository.DummyRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class AuthorControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private DummyRepository dummyRepository;

    @Before
    public void setUp() throws Exception {
        String testJsonPath = TestResourceManager.getSmallTestJsonPath();
        dummyRepository.setTestSourcePatch(testJsonPath);
    }

    @Test
    public void Should_ReturnRatings() throws Exception { //whole logic tested in Library manager test
        this.mockMvc
                .perform(get("/api/rating"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().string("[{\"author\":\"Sir Thomas Stamford Raffles\",\"averageRating\":4.5},{\"author\":\"Clifford Geertz\",\"averageRating\":4.0}]"));
    }
}