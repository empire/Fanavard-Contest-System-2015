package com.fanavard.challenge.words.util;

import com.fanavard.challenge.words.exception.IOException;
import com.fanavard.challenge.words.provider.FileWordProviderBuilder;
import com.fanavard.challenge.words.provider.WordProvider;
import com.fanavard.challenge.words.provider.WordProviderBuilder;
import com.fanavard.challenge.words.repository.WordRepository;
import com.fanavard.challenge.words.repository.WordRepositoryManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by ITRENT2 on 11/23/2015.
 */
@Component
@Scope("singleton")
public class WordLoader {
    private static final Logger logger = LoggerFactory.getLogger(WordLoader.class);

    @Autowired
    ApplicationContext context;

    @Autowired
    WordRepositoryManager repositoryManager;

    public void loadFromFile(String repositoryName, String filename) {
        addToRepository(filename, getWordRepository(repositoryName));
    }

    private void addToRepository(String filename, WordRepository repository) {
        logger.debug("Load from file {}", filename);
        WordProvider wordProvider = getWordProviderFromFileName(filename);
        repository.addAll(wordProvider);
    }

    private WordRepository getWordRepository(String repositoryName) {
        return repositoryManager.getRepository(repositoryName);
    }

    private WordProvider getWordProviderFromFileName(String filename) {
        return getWordProviderBuilder(filename).build();
    }

    private WordProviderBuilder getWordProviderBuilder(String filename) {
        return context.getBean(FileWordProviderBuilder.class, getAbsolutePath(filename));
    }

    private String getAbsolutePath(String filename) {
        try {
            return context.getResource(filename).getURL().getFile();
        } catch (java.io.IOException e) {
            throw new IOException(e);
        }
    }
}
