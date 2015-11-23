package com.fanavard.challenge.server;

import com.fanavard.challenge.game.GameManager;
import com.fanavard.challenge.words.repository.WordRepositoryManager;
import com.fanavard.challenge.words.util.WordLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ITRENT2 on 11/23/2015.
 */
@Component
public class ConsoleServerApplication implements ServerApplication {
    private static final Logger logger = LoggerFactory.getLogger(ConsoleServerApplication.class);

    @Autowired
    WordLoader wordLoader;
	
    @Autowired
    WordRepositoryManager repositoryManager;

    @Autowired
    GameManager gameManager;

    public void run() {
        logger.debug("Server application is started!");
        wordLoader.loadFromFile("flowers", "flowers.txt");
        logger.debug("contains word {}", repositoryManager.getRepository("flowers").contains("کوکب"));
        gameManager.games();
        try {
            DiscardServer.main(new String[] {});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
