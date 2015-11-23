package com.fanavard.challenge.game;

import java.util.Collection;

/**
 * Created by ITRENT2 on 11/23/2015.
 */
public interface GameManager {
    Collection<NameFamilyGame> games();

    NameFamilyGame newGame(int numberOfPlayers);

    NameFamilyGame findGameId(int id);
}
