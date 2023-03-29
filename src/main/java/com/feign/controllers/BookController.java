package com.feign.controllers;

import com.feign.client.BookClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookClient bookClient;

    @GetMapping("/fetch-books")
    public void testBook() {
        bookClient.getBooks();
    }
}
