package com.fanavard.challenge.repository.provider;

import org.springframework.stereotype.Component;

/**
 * Created by ITRENT2 on 11/23/2015.
 */
public class FileWordProviderBuilder implements WordProviderBuilder {
    private final String filename;

    FileWordProviderBuilder(String filename) {
        this.filename = filename;
    }

    public WordProvider build() {
        FileWordProvider fileWordProvider = new FileWordProvider();
        fileWordProvider.open(filename);
        return fileWordProvider;
    }
}
