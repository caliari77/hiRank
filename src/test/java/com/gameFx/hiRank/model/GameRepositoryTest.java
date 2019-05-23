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

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@RunWith(SpringRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class,
        classes = TestBeans.class)
@Transactional
public class GameRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;
    private Game game;
    private Rank rank;
    private Genre genre;
    private Category category;

    private static final String GAME_NAME = "gameName";
    private static final String GENRE_NAME = "genreName";
    private static final String CATEGORY_NAME = "categoryName";
    private static final Integer RANK_LEVEL = 10;


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

        assertNotNull(savedGame.getGameId());
        assertThat(savedGame.getName(), equalTo(GAME_NAME));
    }

    @Test
    public void setRankLevelAndPersistGame_shouldPersist() {
        rank.setRankFormat(RankFormat.ZERO_TO_TEN);
        rank.setLevel(RANK_LEVEL);
        game.setRank(rank);

        Game savedGame = entityManager.persistAndFlush(game);
        Rank savedRank = savedGame.getRank();

        assertNotNull(savedRank.getId());
        assertThat(savedRank.getLevel(), equalTo(RANK_LEVEL));
        assertThat(savedRank.getRankFormat(), equalTo(RankFormat.ZERO_TO_TEN));
    }

    @Test
    public void setGenreAndPersistGame_shouldPersist() {
        genre.setCategoryList(Collections.singletonList(new Category()));
        genre.setName(GENRE_NAME);
        game.setGenreList(Collections.singletonList(genre));

        Game savedGame = entityManager.persistAndFlush(game);
        Genre savedGenre = savedGame.getGenreList()
                .stream()
                .findAny()
                .orElse(new Genre());

        assertNotNull(savedGenre.getCategoryList());
        assertThat(savedGenre.getName(), equalTo(GENRE_NAME));
    }

    @Test
    public void setCategoryAndPersistGame_shouldPersist() {
        category.setName(CATEGORY_NAME);
        category.setGenre(genre);

        genre.setCategoryList(Collections.singletonList(category));
        game.setGenreList(Collections.singletonList(genre));

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

        assertNotNull(savedCategory);
        assertThat(savedCategory.getName(), equalTo(CATEGORY_NAME));
    }

}
