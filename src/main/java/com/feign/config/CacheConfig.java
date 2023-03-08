package com.feign.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {

    public static final String BOOK_CACHE = "books";

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager(BOOK_CACHE);
    }
}
