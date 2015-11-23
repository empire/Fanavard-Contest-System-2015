package com.fanavard.challenge.repository.exception;

import java.io.FileNotFoundException;

/**
 * Created by ITRENT2 on 11/23/2015.
 */
public class IOException extends RuntimeException {
    public IOException(java.io.IOException e) {
        super(e);
    }
}
