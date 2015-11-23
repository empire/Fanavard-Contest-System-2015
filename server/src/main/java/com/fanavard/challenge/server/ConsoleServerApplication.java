package com.fanavard.challenge.server;

import com.fanavard.challenge.repository.exception.IOException;
import com.fanavard.challenge.repository.provider.FileWordProviderBuilder;
import com.fanavard.challenge.repository.provider.WordProvider;
import com.fanavard.challenge.repository.provider.WordProviderBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by ITRENT2 on 11/23/2015.
 */
@Component
public class ConsoleServerApplication implements ServerApplication {
    private static final Logger logger = LoggerFactory.getLogger(ConsoleServerApplication.class);

    @Autowired
    ApplicationContext context;

    public void start(String[] args) {
        logger.debug("Server application is started!");
        WordProviderBuilder builder = context.getBean(FileWordProviderBuilder.class, getAbsolutePath("flowers.txt"));
        WordProvider wordProvider = builder.build();
        while (wordProvider.hasNext()) {
            System.out.println(wordProvider.next());
        }
    }

    private String getAbsolutePath(String filename) {
        try {
            return context.getResource(filename).getURL().getFile();
        } catch (java.io.IOException e) {
            throw new IOException(e);
        }
    }
}
