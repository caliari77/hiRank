package com.gameFx.hiRank.dao;

import com.gameFx.hiRank.model.*;
import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;


public class ExportDataPopulatorJson {
    public static void main(String args[]) {

        Category category1 = new Category("action");
        Category category2 = new Category("sandbox");

        Genre genre1 = new Genre("First-person-shooter");
        Genre genre2 = new Genre("Classic");

        genre1.setCategoryList(Arrays.asList(category1, category2));

        Game doom = new Game.GameBuilder()
                .withName("Doom")
                .withGenre(Arrays.asList(genre1, genre2))
                .withRank(new Rank(10, RankFormat.ZERO_TO_TEN))
                .build();

        Game halo = new Game.GameBuilder()
                .withName("Halo")
                .withGenre(Arrays.asList(genre1))
                .withRank(new Rank(8, RankFormat.ZERO_TO_TEN))
                .build();

        writeFile(new Gson().toJson(Arrays.asList(doom, halo)));
    }

    private static void writeFile(String jsonAsString) {
        Path path = Paths.get("./oldButGold.json");

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(jsonAsString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
