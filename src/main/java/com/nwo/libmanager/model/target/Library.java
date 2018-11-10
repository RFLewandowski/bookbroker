package com.nwo.libmanager.model.target;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Library {
    //    @JsonProperty("booksFromLibrary")
    List<Book> booksFromLibrary = new ArrayList<>();
}
