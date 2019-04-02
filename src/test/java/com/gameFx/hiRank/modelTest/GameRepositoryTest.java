package com.gameFx.hiRank.modelTest;

import com.gameFx.hiRank.model.Game;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class GameRepositoryTest {

    private static final String GAME_NAME = "gameName";
    private static final Long GAME_ID = 1L;

    @Autowired
    private TestEntityManager entityManager;
    private Game game;

    public void setup() {
        game = new Game();
        game.setId(GAME_ID);
        game.setName(GAME_NAME);
    }

    @Test
    public void saveGame_shouldPersist() {
        Game savedGame = entityManager.persistAndFlush(game);
        assertThat(savedGame.getName(), equalTo(GAME_NAME));
    }
}
