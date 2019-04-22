package com.gameFx.hiRank.service;

import com.gameFx.hiRank.bean.GameRepository;
import com.gameFx.hiRank.model.Game;
import com.gameFx.hiRank.model.TestBeans;
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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class,
        classes = {TestBeans.class, GameBrowser.class})
public class GameBrowserTest {

    @MockBean
    GameRepository gameRepository;

    @Autowired
    GameBrowser gameBrowser;

    private Game game1;
    private Game game2;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);

        game1 = new Game.GameBuilder().withName("game1").build();
        game2 = new Game.GameBuilder().withName("game2").build();
    }

    @Test
    public void findAllGames_shouldReturn(){
        final String result = "{\"name\":\"game1\"}{\"name\":\"game2\"}";
        when(gameRepository.findAll()).thenReturn(Arrays.asList(game1,game2));
        assertThat(gameBrowser.getAllGames(), equalTo(result));
    }
}
