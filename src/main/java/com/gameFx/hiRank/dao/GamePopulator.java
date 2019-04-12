package com.gameFx.hiRank.dao;

import com.gameFx.hiRank.model.Game;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GamePopulator implements DataPopulator{

    @Autowired
    GameRepository gr;

    private static final String FILE_NAME_FOR_GAMELIST = "./oldButGold.json";

    @Override
    public void populate() {
        loadGameFromJson().stream().map(gr::save);
    }

    private List<Game> loadGameFromJson(){
        return Arrays.asList(new Gson().fromJson(readFile(FILE_NAME_FOR_GAMELIST), Game[].class));
    }

    private String readFile(String filePath){
        Path path = null;
        try {
            path = Paths.get(getClass().getClassLoader()
                    .getResource(filePath).toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        Stream<String> lines = null;
        try {
            lines = Files.lines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String data = lines.collect(Collectors.joining("\n"));
        lines.close();
        return data;
    }

}
