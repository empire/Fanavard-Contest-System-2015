package com.fanavard.challenge.client;

import com.fanavard.challenge.client.socket.SocketClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ITRENT2 on 11/23/2015.
 */
@Component
public class ClientApplication implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(ClientApplication.class);

    @Autowired
    SocketClient socketClient;

    public void run() {
        logger.debug("Starting client");
        try {
            socketClient.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
