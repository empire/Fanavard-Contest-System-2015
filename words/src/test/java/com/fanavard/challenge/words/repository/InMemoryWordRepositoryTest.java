package com.fanavard.challenge.words.repository;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ITRENT2 on 11/23/2015.
 */
public class InMemoryWordRepositoryTest {
    public static final String WORD = "sample";
    private InMemoryWordRepository wordRepository;

    @Before
    public void setup() {
        wordRepository = new InMemoryWordRepository();
    }

    @Test
    public void testContainsMustNotContainsNotAddedWord() throws Exception {
        assertFalse(wordRepository.contains(WORD));
    }

    @Test
    public void testContainsMustNotContainsAddedWord() throws Exception {
        wordRepository.add(WORD);
        assertFalse(wordRepository.contains(WORD));
    }
}
