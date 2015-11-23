package com.fanavard.challenge.server;

import org.springframework.stereotype.Component;

/**
 * Created by ITRENT2 on 11/23/2015.
 */
@Component
public class ConsoleServerApplication implements ServerApplication {
    public void start(String[] args) {
        System.out.println("Server application is started!");
    }
}
