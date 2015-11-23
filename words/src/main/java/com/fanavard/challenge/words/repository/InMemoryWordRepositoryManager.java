package com.fanavard.challenge.words.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by ITRENT2 on 11/23/2015.
 */
@Component
@Scope("singleton")
class InMemoryWordRepositoryManager implements WordRepositoryManager {
    private static final Logger logger = LoggerFactory.getLogger(InMemoryWordRepositoryManager.class);

    private final Map<String, WordRepository> repositories = new TreeMap<>();

    public InMemoryWordRepositoryManager() {
    }

    public synchronized WordRepository getRepository(String repositoryName) {
        if (!containsRepository(repositoryName)) {
            addNewRepository(repositoryName);
        }

        return getWordRepository(repositoryName);
    }

    private WordRepository getWordRepository(String repositoryName) {
        return repositories.get(repositoryName);
    }

    private WordRepository addNewRepository(String repositoryName) {
        return repositories.put(repositoryName, buildRepository());
    }

    private boolean containsRepository(String repositoryName) {
        return repositories.containsKey(repositoryName);
    }

    private InMemoryWordRepository buildRepository() {
        return new InMemoryWordRepository();
    }
}
