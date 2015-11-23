package com.fanavard.challenge.server;

import com.fanavard.challenge.words.exception.IOException;
import com.fanavard.challenge.words.provider.FileWordProviderBuilder;
import com.fanavard.challenge.words.provider.WordProvider;
import com.fanavard.challenge.words.provider.WordProviderBuilder;
import com.fanavard.challenge.words.repository.WordRepository;
import com.fanavard.challenge.words.repository.WordRepositoryManager;
import com.fanavard.challenge.words.util.WordLoader;
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
    WordLoader wordLoader;
	
    @Autowired
    WordRepositoryManager repositoryManager;


    public void start(String[] args) {
        logger.debug("Server application is started!");
        wordLoader.loadFromFile("flowers", "flowers.txt");

        logger.debug("'{}'", "abc");
        logger.debug("contains word {}", repositoryManager.getRepository("flowers").contains("کوکب"));
    }
}
