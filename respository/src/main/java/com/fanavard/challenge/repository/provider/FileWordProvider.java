package com.fanavard.challenge.repository.provider;

import com.fanavard.challenge.repository.exception.IOException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

    void open(String filename) {
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(filename)));
        } catch (FileNotFoundException e) {
            new IOException(e);
        }
    }
}
