package com.gameFx.hiRank.dao;

import com.gameFx.hiRank.model.Game;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@Configurable
@Transactional
public class GamePopulator implements DataPopulator{

    Logger log = Logger.getLogger(GamePopulator.class);

    @Autowired
    private GameRepository gr;

    private String FILE_NAME_FOR_GAMELIST = "./oldButGold.json";

    @Override
    public void populate() {
        List<Game> a = loadGameFromJson();
        a.stream().map(gr::save);
    }

    private List<Game> loadGameFromJson(){
        return Arrays.asList(new Gson().fromJson(readFile(FILE_NAME_FOR_GAMELIST), Game[].class));
    }

    private String readFile(String fileName){
        String data = "";

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            data = stream.collect(Collectors.joining());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

}
