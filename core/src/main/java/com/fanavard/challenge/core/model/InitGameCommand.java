package com.fanavard.challenge.core.model;

/**
 * Created by ocean on 11/24/15.
 */
public class InitGameCommand implements Command {
    private final int playersCount;

    public InitGameCommand(int playersCount) {
        this.playersCount = playersCount;
    }
}
