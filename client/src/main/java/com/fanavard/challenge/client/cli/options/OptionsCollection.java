package com.fanavard.challenge.client.cli.options;

import com.fanavard.challenge.client.cli.states.State;
import com.fanavard.challenge.core.commands.Commander;

/**
 * Created by ITRENT2 on 11/24/2015.
 */
public interface OptionsCollection {
    State getNextState(Commander commander);
}
