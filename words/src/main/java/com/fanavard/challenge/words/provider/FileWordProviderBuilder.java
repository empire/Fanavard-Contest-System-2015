package com.fanavard.challenge.words.provider;

import com.fanavard.challenge.words.exception.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by ITRENT2 on 11/23/2015.
 */
public class FileWordProviderBuilder implements WordProviderBuilder {
    private static final Logger logger = LoggerFactory.getLogger(FileWordProviderBuilder.class);

    private final String filename;

    FileWordProviderBuilder(String filename) {
        this.filename = filename;
    }

    public WordProvider build() {
        logger.debug("Building WordProvider");
        ReaderWordProvider readerWordProvider = new ReaderWordProvider();
        readerWordProvider.open(getReader());
        return readerWordProvider;
    }

    private BufferedReader getReader() {
        try {
            return new BufferedReader(new FileReader(filename));
        } catch (java.io.IOException ex) {
            throw new IOException(ex);
        }
    }
}
