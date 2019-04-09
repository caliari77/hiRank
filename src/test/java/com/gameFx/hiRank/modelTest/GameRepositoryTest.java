package com.gameFx.hiRank.modelTest;

import com.gameFx.hiRank.model.Game;
import com.gameFx.hiRank.model.Genre;
import com.gameFx.hiRank.model.Rank;
import org.hamcrest.Matcher;
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

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class,
        classes = TestBeans.class)
@Transactional
public class GameRepositoryTest {

    private static final String GAME_NAME = "gameName";
    private static final String GENRE_NAME = "genreName";


    @Autowired
    private TestEntityManager entityManager;
    private Game game;
    private Rank rank;
    private Genre genre;

    @Before
    public void setup() {
        game = new Game();
        rank = new Rank();
        genre = new Genre();
    }

    @Test
    public void setGameNameAndPersistGame_shouldPersist() {
        game.setName(GAME_NAME);
        Game savedGame = entityManager.persistAndFlush(game);

        assertTrue(savedGame.getGameId()!=null);
        assertThat(savedGame.getName(), equalTo(GAME_NAME));
    }

    @Test
    public void setRankLevelAndPersistGame_shouldPersist() {
        Integer rankLevel = 10;
        rank.setLevel(rankLevel);
        game.setRank(rank);

        Game savedGame = entityManager.persistAndFlush(game);
        Rank savedRank = savedGame.getRank();

        assertTrue(savedRank.getId()!=null);
        assertThat(savedRank.getLevel(), equalTo(rankLevel));
    }



    @After
    public void tearDown() {
        entityManager.clear();
    }
}
