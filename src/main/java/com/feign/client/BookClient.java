package com.feign.client;

import com.feign.client.fallback.BookClientFallbackFactory;
import com.feign.dto.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "book", contextId = "bookClient", fallbackFactory = BookClientFallbackFactory.class)
public interface BookClient {
    Logger log = LoggerFactory.getLogger(BookClient.class);

    //    @CircuitBreaker(name = "bookCB", fallbackMethod = "getBooksFallback")
    @GetMapping("/")
    Book getBooks();

//    default Book getBooksFallback(Throwable e) throws Throwable {
//        log.error("Here it comes with error", e);
//        throw new IllegalStateException();
//    }

}
