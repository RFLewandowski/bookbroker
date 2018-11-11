package com.nwo.libmanager.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Book not found in Library, please check your ISBN/ID")
public class BookNotFoundException extends Exception {
}
