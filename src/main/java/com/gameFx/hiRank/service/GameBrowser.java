package com.gameFx.hiRank.service;

import com.gameFx.hiRank.bean.GameRepository;
import com.gameFx.hiRank.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameBrowser implements Discovery {

    @Autowired
    GameRepository gameRepository;

    @Override
    public List<Game> getAllGames() {
         //return GamePojo2GameJson.traslate(gameRepository.findAll());
        return gameRepository.findAll();
    }
}
