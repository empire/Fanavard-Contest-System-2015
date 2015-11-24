package com.fanavard.challenge.client.cli.states;

import com.fanavard.challenge.core.commands.Commander;

/**
 * Created by ITRENT2 on 11/24/2015.
 */
public interface OptionsCollection {
    State getNextState(Commander commander);
}
