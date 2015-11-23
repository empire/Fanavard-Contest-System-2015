package com.fanavard.challenge.game.inmemory;

import com.fanavard.challenge.game.NameFamilyGame;
import com.fanavard.challenge.game.Player;
import com.fanavard.challenge.game.exception.GameRoomIsFullException;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ITRENT2 on 11/23/2015.
 */
public class InMemoryNameFamilyGame implements NameFamilyGame {
    private int numberOfPlayers;
    private Set<Player> players = new HashSet<>();
    
    private static int gameCount = 1;
    private int gameId = gameCount ++;

    public InMemoryNameFamilyGame(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    @Override
    public int hashCode() {
        return gameId;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof InMemoryNameFamilyGame)) {
            return false;
        }
        
        InMemoryNameFamilyGame anotherGame = (InMemoryNameFamilyGame) obj;
        return this.gameId == anotherGame.gameId;
    }

    public int getIdentifier() {
        return gameId;
    }

    @Override
    public void joinToGame(Player player) {
        synchronized (players) {
            checkGameSpace();
            players.add(player);
        }
    }

    @Override
    public boolean isAllPlayerJoined() {
        return numberOfPlayers == players.size();
    }

    private void checkGameSpace() {
        if (players.size() >= numberOfPlayers) {
            throw new GameRoomIsFullException();
        }
    }
}
