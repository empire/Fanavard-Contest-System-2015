package com.fanavard.challenge.game;

/**
 * Created by ITRENT2 on 11/23/2015.
 */
public interface NameFamilyGame {
    int getIdentifier();

    void joinToGame(Player player);

    boolean isAllPlayerJoined();
}
