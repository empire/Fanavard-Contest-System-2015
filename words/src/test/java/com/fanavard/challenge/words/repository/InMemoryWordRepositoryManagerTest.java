package com.fanavard.challenge.words.repository;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ITRENT2 on 11/23/2015.
 */
public class InMemoryWordRepositoryManagerTest {
    private InMemoryWordRepositoryManager repositoryManager;

    @Before
    public void setup() {
        repositoryManager = new InMemoryWordRepositoryManager();
    }

    @Test
    public void testGettingNewRepositoryMustBuildRepository() {
        WordRepository fistRepository = repositoryManager.getRepository("sample");
        assertNotNull(fistRepository);
    }

    @Test
    public void testGettingNewRepositoryMustGetSameRepository() {
        WordRepository fistRepository = repositoryManager.getRepository("sample");
        WordRepository secondRepository = repositoryManager.getRepository("sample");
        assertEquals(fistRepository, secondRepository);
    }

    @Test
    public void testGettingNewRepositoryMustDifferentRepository() {
        WordRepository fistRepository = repositoryManager.getRepository("sample");
        WordRepository secondRepository = repositoryManager.getRepository("simple");
        assertNotEquals(fistRepository, secondRepository);
    }
}