package com.fanavard.challenge.client;

import org.springframework.stereotype.Component;

/**
 * Created by ITRENT2 on 11/23/2015.
 */
@Component
public class ClientApplication implements Runnable {
    public void run() {
        System.out.println("Starting client");
    }
}
