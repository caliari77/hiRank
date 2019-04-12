package com.gameFx.hiRank;

import com.gameFx.hiRank.dao.GameRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class HiRankApplication implements CommandLineRunner {

	@Autowired
	GameRepository gr;

	Logger log = Logger.getLogger(HiRankApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HiRankApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
//		log.info("Checking if DB is empty...");
//		if(gr.findAll().isEmpty()){
//			new GamePopulator().populate();
//			log.info("DataPopulator has been loaded");
//		}

	}
}
