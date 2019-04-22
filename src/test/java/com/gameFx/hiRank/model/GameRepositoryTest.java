package com.gameFx.hiRank.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class,
        classes = TestBeans.class)
@Transactional
public class GameRepositoryTest {

    private static final String GAME_NAME = "gameName";
    private static final String GENRE_NAME = "genreName";
    private static final String CATEGORY_NAME = "categoryName";
    private static final Integer RANK_LEVEL = 10;


    @Autowired
    private TestEntityManager entityManager;
    private Game game;
    private Rank rank;
    private Genre genre;
    private Category category;

    @Before
    public void setup() {
        game = new Game();
        rank = new Rank();
        genre = new Genre();
        category = new Category();
    }

    @Test
    public void setGameNameAndPersistGame_shouldPersist() {
        game.setName(GAME_NAME);
        Game savedGame = entityManager.persistAndFlush(game);

        assertTrue(savedGame.getGameId() != null);
        assertThat(savedGame.getName(), equalTo(GAME_NAME));
    }

    @Test
    public void setRankLevelAndPersistGame_shouldPersist() {
        rank.setRankFormat(RankFormat.ZERO_TO_TEN);
        rank.setLevel(RANK_LEVEL);
        game.setRank(rank);

        Game savedGame = entityManager.persistAndFlush(game);
        Rank savedRank = savedGame.getRank();

        assertTrue(savedRank.getId() != null);
        assertThat(savedRank.getLevel(), equalTo(RANK_LEVEL));
        assertThat(savedRank.getRankFormat(), equalTo(RankFormat.ZERO_TO_TEN));
    }

    @Test
    public void setGenreAndPersistGame_shouldPersist() {
        genre.setCategoryList(Arrays.asList(new Category()));
        genre.setName(GENRE_NAME);
        game.setGenreList(Arrays.asList(genre));

        Game savedGame = entityManager.persistAndFlush(game);
        Genre savedGenre = savedGame.getGenreList()
                .stream()
                .findAny()
                .orElse(new Genre());

        assertThat(savedGenre.getName(), equalTo(GENRE_NAME));
        assertTrue(savedGenre.getCategoryList() != null);
    }

    @Test
    public void setCategoryAndPersistGame_shouldPersist() {
        category.setName(CATEGORY_NAME);
        category.setGenre(genre);

        genre.setCategoryList(Arrays.asList(category));
        game.setGenreList(Arrays.asList(genre));

        Game savedGame = entityManager.persistAndFlush(game);

        List<Category> savedCategoryList = savedGame.getGenreList()
                .stream()
                .findAny()
                .orElse(new Genre())
                .getCategoryList();

        Category savedCategory = savedCategoryList
                .stream()
                .findAny()
                .orElse(new Category());

        assertTrue(savedCategory != null);
        assertThat(savedCategory.getName(), equalTo(CATEGORY_NAME));
    }

}
