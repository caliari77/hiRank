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
    public static void main(String args[]){
        Rank rank = new Rank();
        Genre genre1 = new Genre();

        Category category1 = new Category();
        category1.setName("action");
        Category category2 = new Category();
        category2.setName("open world");

        genre1.setName("First-person-shooter");
        genre1.setCategory(Arrays.asList(category1, category2));

        rank.setLevel(10);
        rank.setRankFormat(RankFormat.ZERO_TO_TEN);

        Game game = new Game.GameBuilder()
                .create()
                .withName("Doom")
                .withGenre(Arrays.asList(genre1))
                .withRank(rank)
                .build();

        writeFile(new Gson().toJson(Arrays.asList(game)));
    }

    private static void writeFile(String jsonAsString){
        Path path = Paths.get("./oldButGold.json");

        try (BufferedWriter writer = Files.newBufferedWriter(path))
        {
            writer.write(jsonAsString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
