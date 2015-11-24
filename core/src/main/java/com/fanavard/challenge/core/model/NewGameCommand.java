package com.fanavard.challenge.core.model;

/**
 * Created by ocean on 11/24/15.
 */
public class NewGameCommand implements Command {
    private final int playersCount;

    public NewGameCommand(int playersCount) {
        this.playersCount = playersCount;
    }

    public int getPlayersCount() {
        return playersCount;
    }
}
