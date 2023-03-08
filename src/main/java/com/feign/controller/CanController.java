package com.feign.controller;

import com.feign.client.BookClient;
import com.feign.dto.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.feign.config.CacheConfig.BOOK_CACHE;


@RestController
@Slf4j
public class CanController {

    @Autowired
    private BookClient bookClient;

    @Autowired
    private CacheManager cacheManager;

    @GetMapping("/")
    public Book can() {
        Book books = bookClient.getBooks("1");
        log.info("{}", books);
        return books;
    }

    @GetMapping("/cache")
    public void cach() {
        Map<String, Book> nativeCache = (Map<String, Book>) cacheManager.getCache(BOOK_CACHE).getNativeCache();
        log.info("{}", nativeCache);
    }
}
