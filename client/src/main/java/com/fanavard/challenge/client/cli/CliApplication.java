package com.fanavard.challenge.client.cli;

import com.fanavard.challenge.client.cli.options.OptionsCollection;
import com.fanavard.challenge.client.cli.states.*;
import com.fanavard.challenge.core.commands.Commander;
import com.fanavard.challenge.core.model.Command;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by ITRENT2 on 11/24/2015.
 */
@Component
@Scope("singleton")
public class CliApplication {
    private static final Logger logger = LoggerFactory.getLogger(CliApplication.class);

    State currentState;

    @Autowired
    ApplicationContext context;

    public void run(Channel channel) {
        currentState = context.getBean(StartState.class);
        State endState = context.getBean(JoinGameState.class);
        Commander commander = getCommander(channel);

        while (currentState != endState) {
            logger.debug("Current state {}", currentState);
            if (currentState instanceof WaitingForDataState) {
                break;
            }
            OptionsCollection options = currentState.getOptions();

            currentState = options.getNextState(commander);
        }
    }

    private Commander getCommander(final Channel channel) {
        return new Commander() {
                @Override
                public void sendAsyncCommand(Command command) {
                    channel.writeAndFlush(command);
                }
            };
    }

    public void dataReceived(Channel channel, Object msg) {
        logger.debug("Data received {} current state {}", msg.toString(), currentState);

        if (!(currentState instanceof WaitForStartingOfGameState)) {
            return;
        }

        WaitingForDataState waitingForDataState = (WaitForStartingOfGameState) currentState;
        if (waitingForDataState.supportMessage(msg.getClass())) {
            currentState = waitingForDataState.callWithMessage(msg);
            run(channel);
        }

    }
}
