package com.fanavard.challenge.words.util;

import com.fanavard.challenge.words.provider.UrlWordProviderBuilder;
import com.fanavard.challenge.words.provider.WordProvider;
import com.fanavard.challenge.words.provider.WordProviderBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by ITRENT2 on 11/24/2015.
 */
@Component
public class UrlWordLoader extends AbstractWordLoader {
    private static final Logger logger = LoggerFactory.getLogger(UrlWordLoader.class);

    @Autowired
    ApplicationContext context;

    public void loadFromUrl(String repositoryName, String path) {
        addFileContentsToRepository(path, repositoryName);
    }

    private void addFileContentsToRepository(String path, String repository) {
        logger.debug("Load from path {}", path);
        WordProvider wordProvider = getWordProviderFromUrl(path);
        addFromWordProvider(repository, wordProvider);
    }

    private WordProvider getWordProviderFromUrl(String path) {
        return getWordProviderBuilder(path).build();
    }

    private WordProviderBuilder getWordProviderBuilder(String path) {
        return context.getBean(UrlWordProviderBuilder.class, path);
    }
}
