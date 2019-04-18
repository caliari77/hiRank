package com.gameFx.hiRank;

import com.gameFx.hiRank.bean.GameRepository;
import com.gameFx.hiRank.dao.GamePopulator;
import com.gameFx.hiRank.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class HiRankApplication implements CommandLineRunner {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    GamePopulator gamePopulator;

    //Logger log = Logger.getLogger(HiRankApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(HiRankApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        //log.info("Checking if DB is empty... If so, then show of data is going to be loaded.");


        if (gameRepository.findAll().isEmpty()) {
            gamePopulator.populate();
            //log.info("Show off data has been loaded");


            List<Game> a = gameRepository.findAll();
            System.out.println("");
        }

    }
}
