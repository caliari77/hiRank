package com.gameFx.hiRank.dao;

import com.gameFx.hiRank.bean.GameRepository;
import com.gameFx.hiRank.io.FileOperations;
import com.gameFx.hiRank.io.JsonOperations;
import com.gameFx.hiRank.model.Game;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Configurable

public class GamePopulator implements DataPopulator {

    Logger log = Logger.getLogger(GamePopulator.class);
    private final GameRepository gr;

    public GamePopulator(GameRepository gr) {
        this.gr = gr;
    }

    private JsonOperations jsonOperations = new FileOperations();

    private String FILE_NAME_FOR_GAMELIST = "./oldButGold.json";

    @Override
    @Transactional
    public void populate() {
        jsonOperations.readJsonToPojoList(FILE_NAME_FOR_GAMELIST, Game.class)
                .stream()
                .forEach(gr::save);
    }
}


