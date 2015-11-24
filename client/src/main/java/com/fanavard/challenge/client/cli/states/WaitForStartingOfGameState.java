package com.fanavard.challenge.client.cli.states;

import com.fanavard.challenge.client.cli.options.AbstractOptionsCollection;
import com.fanavard.challenge.client.cli.options.OptionsCollection;
import com.fanavard.challenge.core.commands.Commander;
import com.fanavard.challenge.core.model.StartCommandResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by ITRENT2 on 11/24/2015.
 */
@Component
public class WaitForStartingOfGameState implements State, WaitingForDataState {
    private static final Logger logger = LoggerFactory.getLogger(WaitForStartingOfGameState.class);

    @Autowired
    ApplicationContext context;

    @Override
    public OptionsCollection getOptions() {
        return new AbstractOptionsCollection() {
            @Override
            protected State getSelectedState(Commander commander) {
                return null;
            }

            @Override
            protected boolean getValidInputFromUser() {
                return true;
            }
        };
    }

    @Override
    public boolean supportMessage(Class<? extends Object> aClass) {
        logger.debug("called with {}", aClass);
        return aClass == StartCommandResponse.class;
    }

    @Override
    public State callWithMessage(Object msg) {
        return context.getBean(StartState.class);
    }
}
