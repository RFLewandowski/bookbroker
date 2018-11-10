package com.nwo.libmanager.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.nwo.libmanager.model.source.Books;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class SourceFileReader {
    public static final String SOURCE_PATH = "C:\\Users\\HP\\Desktop\\source\\source.json";

    public static Books readSource(String filePath) {//should get path as arg
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
