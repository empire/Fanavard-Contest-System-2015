package com.fanavard.challenge.server.command.runners;

import com.fanavard.challenge.core.model.Command;
import com.fanavard.challenge.core.model.CommandResponse;
import com.fanavard.challenge.core.model.NewGameCommand;
import com.fanavard.challenge.core.model.NewGameResponse;
import com.fanavard.challenge.game.GameManager;
import com.fanavard.challenge.server.command.CommandRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ITRENT2 on 11/24/2015.
 */
@Component
public class NewGameCommandRunner implements CommandRunner<NewGameCommand> {
    private static Logger logger = LoggerFactory.getLogger(NewGameCommandRunner.class);

    @Autowired
    GameManager gameManager;

    @Override
    public CommandResponse run(NewGameCommand command) {
        return new NewGameResponse(gameManager.newGame(command.getPlayersCount()).getIdentifier());
    }

    @Override
    public Class<? extends Command> getCommandClass() {
        return NewGameCommand.class;
    }
}
