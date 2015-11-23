package com.fanavard.challenge.words.repository;

import com.fanavard.challenge.words.provider.WordProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ITRENT2 on 11/23/2015.
 */
public class InMemoryWordRepository implements WordRepository {
    private static final Logger logger = LoggerFactory.getLogger(InMemoryWordRepository.class);

    private final Set<String> words = new HashSet<>();

    public boolean contains(String word) {
        return words.contains(word);
    }

    @Override
    public void add(String word) {
        words.add(word);
    }

    @Override
    public void addAll(WordProvider wordProvider) {
        logger.debug("Adding from word provider");
        while (wordProvider.hasNext()) {
            add(wordProvider.next());
        }
    }

    @Override
    public String toString() {
        return words.toString();
    }
}
