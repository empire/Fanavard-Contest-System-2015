package com.fanavard.challenge.game;

import com.fanavard.challenge.game.inmemory.InMemoryGameManager;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by ITRENT2 on 11/23/2015.
 */
public class InMemoryGameManagerTest {
    InMemoryGameManager gameManager;
    private NameFamilyGame firstGame;
    private NameFamilyGame secondGame;

    @Before
    public void setUp() throws Exception {
        gameManager = new InMemoryGameManager();
        firstGame = gameManager.newGame(3);
        secondGame = gameManager.newGame(5);
    }

    @Test
    public void testGamesMustHaveGame() throws Exception {
        Collection<NameFamilyGame> games = gameManager.games();
        assertEquals(2, games.size());
    }

    @Test
    public void testGamesMustContainsGames() throws Exception {
        Collection<NameFamilyGame> games = gameManager.games();
        assertTrue(games.contains(firstGame));
        assertTrue(games.contains(secondGame));
        assertFalse(games.contains("abc"));
    }

    @Test
    public void testFindGameId() throws Exception {
        assertEquals(firstGame, gameManager.findGameId(firstGame.getIdentifier()));
        assertEquals(secondGame, gameManager.findGameId(secondGame.getIdentifier()));
    }
}