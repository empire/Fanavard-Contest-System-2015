package com.fanavard.challenge.client.cli.states;

import com.fanavard.challenge.client.cli.options.CliStateOption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ITRENT2 on 11/24/2015.
 */
public abstract class AbstractOptionsCollection implements OptionsCollection {
    private static final Logger logger = LoggerFactory.getLogger(AbstractOptionsCollection.class);

    public static OptionsCollection emptyCollection() {
        return new ConcreteOptionsCollection();
    }

    public State getNextState() {
        while (!getValidInputFromUser()) {
        }
        return getSelectedState();
    }

    protected abstract State getSelectedState();
    protected abstract boolean getValidInputFromUser();
}
