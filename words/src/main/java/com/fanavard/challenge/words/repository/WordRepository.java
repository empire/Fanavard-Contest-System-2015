package com.fanavard.challenge.words.repository;

import com.fanavard.challenge.words.provider.WordProvider;

/**
 * Created by ITRENT2 on 11/23/2015.
 */
public interface WordRepository {
    boolean contains(String word);

    void add(String word);

    void addAll(WordProvider wordProvider);
}
