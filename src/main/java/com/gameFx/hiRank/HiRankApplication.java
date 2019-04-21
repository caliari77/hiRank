package com.gameFx.hiRank;

import com.gameFx.hiRank.bean.GameRepository;
import com.gameFx.hiRank.dao.GamePopulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class HiRankApplication implements CommandLineRunner {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    GamePopulator gamePopulator;

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
