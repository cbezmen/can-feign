package com.feign.client;

import feign.RetryableException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@SpringBootTest
class BookClientTest {

    @Autowired
    private BookClient bookClient;

    @Test
    void errorWrappedWithNoFallbackAvailableException() {
        assertThatThrownBy(() -> bookClient.getBooks())
                .isInstanceOf(RetryableException.class);
    }


}