package com.feign.client;

import com.feign.dto.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "book", contextId = "bookClient", path = "/customPrefix")
public interface BookClient {

    @GetMapping("/")
    Book getBooks();


}
