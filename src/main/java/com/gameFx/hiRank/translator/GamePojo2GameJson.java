package com.gameFx.hiRank.translator;


import com.gameFx.hiRank.model.Game;
import com.google.gson.Gson;

import java.util.List;
import java.util.stream.Collectors;

public class GamePojo2GameJson {

    public static String traslate(List<Game> gameList){
        Gson gson = new Gson();

        return gameList.stream()
                .map(game -> gson.toJson(game, Game.class))
                .collect(Collectors.joining());
    }


}
