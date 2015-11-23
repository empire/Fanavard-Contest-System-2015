package com.fanavard.challenge.words.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by ITRENT2 on 11/23/2015.
 */
@Configuration
public class ProviderConfig {
    private static final Logger logger = LoggerFactory.getLogger(ProviderConfig.class);

    @Bean
    @Scope("prototype")
    FileWordProviderBuilder getFileWordProviderBuilder(String filename) {
        logger.debug("get build for file: '{}'", filename);
        return new FileWordProviderBuilder(filename);
    }
}
