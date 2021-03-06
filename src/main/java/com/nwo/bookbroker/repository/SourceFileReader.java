package com.nwo.bookbroker.repository;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.nwo.bookbroker.model.source.Books;

import java.io.File;
import java.io.IOException;

public class SourceFileReader {

    private SourceFileReader() {
    }

    public static Books readSource(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        Books books = new Books();
        try {
            books = objectMapper.readValue(new File(filePath), Books.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }
}