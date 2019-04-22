package com.gameFx.hiRank.translator;

import com.gameFx.hiRank.model.Game;
import com.gameFx.hiRank.model.Game.GameBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class GamePojo2GameJsonTest {

    private Game game1;
    private Game game2;

    @Before
    public void setup(){
        game1 = new GameBuilder().withName("game1").build();
        game2 = new GameBuilder().withName("game2").build();
    }

    @Test
    public void translateGamePojoList2GameJsonList_shouldReturnGameListAsJson(){
        final String result = "{\"name\":\"game1\"}{\"name\":\"game2\"}";
        assertThat(GamePojo2GameJson.traslate(Arrays.asList(game1,game2)), equalTo(result));
    }

}
