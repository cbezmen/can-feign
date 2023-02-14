package com.feign.client.fallback;

import com.feign.client.BookClient;
import com.feign.dto.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BookClientFallbackFactory implements FallbackFactory<BookClient> {


    @Override
    public BookClient create(Throwable cause) {
        return new BookClient() {
            @Override
            public Book getBooks() {
                log.error("Here it comes with error", cause);
                throw new IllegalStateException();
            }
        };
    }
}
