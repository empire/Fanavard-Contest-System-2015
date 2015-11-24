package com.fanavard.challenge.client.cli.states;

import com.fanavard.challenge.client.cli.options.AbstractOptionsCollection;
import com.fanavard.challenge.client.cli.options.OptionsCollection;
import org.springframework.stereotype.Component;

/**
 * Created by ITRENT2 on 11/24/2015.
 */
@Component
public class JoinGameState implements State{
    @Override
    public OptionsCollection getOptions() {
        return AbstractOptionsCollection.emptyCollection();
    }
}
