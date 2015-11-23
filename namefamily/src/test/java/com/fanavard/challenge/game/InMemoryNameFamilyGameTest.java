package com.fanavard.challenge.game;

import com.fanavard.challenge.game.exception.GameRoomIsFullException;
import com.fanavard.challenge.game.inmemory.InMemoryNameFamilyGame;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by ITRENT2 on 11/23/2015.
 */
public class InMemoryNameFamilyGameTest {
    private NameFamilyGame game;


    @Before
    public void setUp() throws Exception {
        game = new InMemoryNameFamilyGame(2);
    }

    @Test
    public void testJoinToGame() throws Exception {
        game.joinToGame(mock(Player.class));
        assertFalse(game.isAllPlayerJoined());
    }

    @Test(expected = GameRoomIsFullException.class)
    public void testJoinToGameThrowsException() throws Exception {
        game.joinToGame(mock(Player.class));
        game.joinToGame(mock(Player.class));
        assertTrue(game.isAllPlayerJoined());
        game.joinToGame(mock(Player.class));
    }
}