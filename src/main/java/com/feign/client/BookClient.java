package com.feign.client;

import com.feign.dto.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.feign.config.CacheConfig.BOOK_CACHE;


@FeignClient(name = "book", contextId = "bookClient")
public interface BookClient {
    Logger log = LoggerFactory.getLogger(BookClient.class);

    @GetMapping("/")
    @Cacheable(cacheNames = BOOK_CACHE, key = "'book:' + #id")
    Book getBooks(@RequestParam(value = "id") String id);

}
