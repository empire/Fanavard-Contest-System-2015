package com.fanavard.challenge.server.command;

import com.fanavard.challenge.core.model.Command;

/**
 * Created by ITRENT2 on 11/24/2015.
 */
public interface CommandRunnerRegistry {
    void register(Class<? extends Command> commandClass, CommandRunner commandRunner);
}
