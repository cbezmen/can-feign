package com.feign.controller;

import com.feign.client.BookClient;
import com.feign.dto.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class CanController {

    @Autowired
    private BookClient bookClient;

    @GetMapping("/")
    public Book can() {
        Book books = bookClient.getBooks("1");
        log.info("{}", books);
        return books;
    }
}
