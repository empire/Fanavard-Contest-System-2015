package com.fanavard.challenge.words.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by ITRENT2 on 11/24/2015.
 */

public class UrlWordProviderBuilder implements WordProviderBuilder {
    private static final Logger logger = LoggerFactory.getLogger(UrlWordProviderBuilder.class);
    private String urlPath;
    private URLConnection conn;

    public UrlWordProviderBuilder(String urlPath) {
        this.urlPath = urlPath;
    }

    @Override
    public WordProvider build() {
        logger.debug("Building WordProvider");
        ReaderWordProvider readerWordProvider = new ReaderWordProvider();

        try {
            URL url = new URL(urlPath);
            conn = url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        readerWordProvider.open(getReader());
        return readerWordProvider;
    }

    private Reader getReader() {
        try {
            return new BufferedReader(
                new InputStreamReader(conn.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
