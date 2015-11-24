package com.fanavard.challenge.core.model;

/**
 * Created by ITRENT2 on 11/24/2015.
 */
public class NewGameResponse implements CommandResponse {
    private final int gameId;
    public NewGameResponse(int identifier) {
        gameId = identifier;
    }

    public int getGameId() {
        return gameId;
    }
}
