package com.fanavard.challenge.game.inmemory;

import com.fanavard.challenge.game.GameManager;
import com.fanavard.challenge.game.NameFamilyGame;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by ITRENT2 on 11/23/2015.
 */
@Component
public class InMemoryGameManager implements GameManager {
    private Map<Integer, NameFamilyGame> games = new HashMap<>();

    @Override
    public Collection<NameFamilyGame> games() {
        return Collections.unmodifiableCollection(games.values());
    }

    @Override
    public NameFamilyGame newGame(int numberOfPlayers) {
        NameFamilyGame game = new InMemoryNameFamilyGame(numberOfPlayers);
        games.put(game.getIdentifier(), game);
        return game;
    }

    @Override
    public NameFamilyGame findGameId(int id) {
        return games.get(id);
    }
}
