package com.fanavard.challenge.client.cli.options;

import com.fanavard.challenge.client.cli.states.StartState;
import com.fanavard.challenge.client.cli.states.State;

/**
 * Created by ITRENT2 on 11/24/2015.
 */
public class CliStateOption {

    private final String message;
    private final State state;

    public CliStateOption(String message, State state) {
        this.message = message;
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public String getMessage() {
        return message;
    }
}
