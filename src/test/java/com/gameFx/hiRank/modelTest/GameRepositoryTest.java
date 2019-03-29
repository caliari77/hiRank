package com.gameFx.hiRank.modelTest;

import com.gameFx.hiRank.dao.GameRepository;
import com.gameFx.hiRank.model.Game;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class GameRepositoryTest {

    private static final String GAME_NAME = "gameName";
    private static final Long GAME_ID = 1L;

    @Autowired
    private TestEntityManager entityManager;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private Game game;

    public void setup(){
        game = new Game();
        game.setId(GAME_ID);
        game.setName(GAME_NAME);
    }

    @Test
    public void saveGame_shouldPersist(){
        Game savedGame = entityManager.persistAndFlush(game);
        assertThat(savedGame.getName(), equalTo(GAME_NAME));
    }
}
