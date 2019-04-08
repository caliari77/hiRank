package com.gameFx.hiRank.modelTest;

import com.gameFx.hiRank.model.Game;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class,
        classes = TestBeans.class)
@Transactional
public class GameRepositoryTest {

    private static final String GAME_NAME = "gameName";

    @Autowired
    private TestEntityManager entityManager;
    private Game game;

    @Before
    public void setup() {
        game = new Game();
        game.setName(GAME_NAME);
    }

    @Test
    public void saveGame_shouldPersist() {
        Game savedGame = entityManager.persistAndFlush(game);
        assertThat(savedGame.getName(), equalTo(GAME_NAME));
    }

    @After
    public void tearDown() {
        entityManager.clear();
    }
}
