package com.feign.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class BookClientTest {

    @Autowired
    private BookClient bookClient;

    @Test
    void callExceptionFallback() {
        assertThatThrownBy(() -> bookClient.getBooks())
                .isInstanceOf(IllegalStateException.class);
    }


}