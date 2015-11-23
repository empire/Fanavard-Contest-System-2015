package com.fanavard.challenge.words.provider;

/**
 * Created by ITRENT2 on 11/23/2015.
 */
public interface WordProvider {
    boolean hasNext();

    String next();
}
