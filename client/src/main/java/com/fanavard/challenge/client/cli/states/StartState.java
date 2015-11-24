package com.fanavard.challenge.client.cli.states;

import com.fanavard.challenge.client.cli.options.AbstractOptionsCollection;
import com.fanavard.challenge.client.cli.options.CliStateOption;
import com.fanavard.challenge.client.cli.options.ConcreteOptionsCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by ITRENT2 on 11/24/2015.
 */
@Component
@Scope("singleton")
public class StartState implements State {
    @Autowired
    ApplicationContext context;

    @Override
    public AbstractOptionsCollection getOptions() {
        return new ConcreteOptionsCollection(
                new CliStateOption("New Game", context.getBean(NewGameState.class)),
                new CliStateOption("Join Game", context.getBean(JoinGameState.class)),
                new CliStateOption("Cancel", this)
        );
    }
}
