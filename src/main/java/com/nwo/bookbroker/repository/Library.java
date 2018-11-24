package com.nwo.bookbroker.repository;

import com.nwo.bookbroker.model.target.Book;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class Library {
    List<Book> books = new ArrayList<>();
}
