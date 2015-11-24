package com.fanavard.challenge.words.util;

import com.fanavard.challenge.words.provider.WordProvider;
import com.fanavard.challenge.words.repository.WordRepository;
import com.fanavard.challenge.words.repository.WordRepositoryManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ITRENT2 on 11/24/2015.
 */
public abstract class AbstractWordLoader {
    @Autowired
    WordRepositoryManager repositoryManager;

    protected void addFromWordProvider(String repositoryName, WordProvider wordProvider) {
        getWordRepository(repositoryName).addAll(wordProvider);
    }

    private WordRepository getWordRepository(String repositoryName) {
        return repositoryManager.getRepository(repositoryName);
    }
}
