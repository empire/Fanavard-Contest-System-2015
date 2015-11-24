package com.fanavard.challenge.client.cli.states;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by ITRENT2 on 11/24/2015.
 */
@Component
@Scope("singleton")
public class EndState implements State {
    @Override
    public OptionsCollection getOptions() {
        return AbstractOptionsCollection.emptyCollection();
    }
}
