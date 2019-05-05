package com.gameFx.hiRank.dao;

import com.gameFx.hiRank.io.FileOperations;
import com.gameFx.hiRank.io.JsonOperations;
import com.gameFx.hiRank.model.*;

import java.util.Arrays;

public class ExportDataPopulatorJson {
    private static final String EXPORT_FILE_NAME = "./oldButGold.json";

    public static void main(String args[]) {
        JsonOperations jsonOperations = new FileOperations();

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

        jsonOperations.writePojoToJson(EXPORT_FILE_NAME, Arrays.asList(doom, halo));
    }
}
