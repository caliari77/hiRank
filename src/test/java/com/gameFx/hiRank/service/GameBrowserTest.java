package com.gameFx.hiRank.service;

import com.gameFx.hiRank.bean.GameRepository;
import com.gameFx.hiRank.model.Game;
import com.gameFx.hiRank.model.TestBeans;
import com.gameFx.hiRank.search.SimilarSearch;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class,
        classes = {TestBeans.class, GameBrowser.class, SimilarSearch.class})
public class GameBrowserTest {

    @MockBean
    GameRepository gameRepository;

    @Autowired
    Discovery gameBrowser;

    private Game game1;
    private Game game2;
    private String GAME_NAME_1 = "game1";
    private String GAME_NAME_2 = "game2";

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);

        game1 = new Game.GameBuilder().withName(GAME_NAME_1).build();
        game2 = new Game.GameBuilder().withName(GAME_NAME_2).build();

    }

    @Test
    public void findAllGames_shouldReturn(){
        when(gameRepository.findAll()).thenReturn(Arrays.asList(game1,game2));
        List<Game> result = gameBrowser.getAllGames();
        Game resultGame1 = result.stream().filter(game -> game.getName().equals(GAME_NAME_1)).findAny().orElse(new Game());
        Game resultGame2 = result.stream().filter(game -> game.getName().equals(GAME_NAME_2)).findAny().orElse(new Game());
        assertThat(result.size(), equalTo(2));
        assertThat(resultGame1.getName(), equalTo(GAME_NAME_1));
        assertThat(resultGame2.getName(), equalTo(GAME_NAME_2));

    }
}
