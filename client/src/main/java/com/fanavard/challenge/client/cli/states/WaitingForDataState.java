package com.fanavard.challenge.client.cli.states;

/**
 * Created by ITRENT2 on 11/24/2015.
 */
public interface WaitingForDataState {
    boolean supportMessage(Class<? extends Object> aClass);

    State callWithMessage(Object msg);
}
