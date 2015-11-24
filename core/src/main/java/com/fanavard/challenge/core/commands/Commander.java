package com.fanavard.challenge.core.commands;

import com.fanavard.challenge.core.model.Command;
import com.fanavard.challenge.core.model.InitGameCommand;

/**
 * Created by ITRENT2 on 11/24/2015.
 */
public interface Commander {
    void sendAsyncCommand(Command command);
}
