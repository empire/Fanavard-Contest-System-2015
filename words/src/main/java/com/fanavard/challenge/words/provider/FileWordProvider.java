package com.fanavard.challenge.words.provider;

import java.io.Reader;
import java.util.Scanner;

/**
 * Created by ITRENT2 on 11/23/2015.
 */

class FileWordProvider implements WordProvider, AutoCloseable {
    private Scanner scanner;

    public boolean hasNext() {
        return scanner.hasNext();
    }

    public String next() {
        return scanner.next();
    }

    public void close() throws Exception {
        scanner.close();
    }


    void open(Reader reader) {
        scanner = new Scanner(reader);
    }
}
