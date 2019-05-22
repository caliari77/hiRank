package com.gameFx.hiRank;

import com.gameFx.hiRank.bean.GameRepository;
import com.gameFx.hiRank.dao.GamePopulator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class HiRankApplication implements CommandLineRunner {

    private GameRepository gameRepository;
    private GamePopulator gamePopulator;

    public HiRankApplication(GameRepository gameRepository, GamePopulator gamePopulator) {
        this.gamePopulator = gamePopulator;
        this.gameRepository = gameRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(HiRankApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (gameRepository.findAll().isEmpty()) {
            gamePopulator.populate();
        }
    }
}
