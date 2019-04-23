package com.gameFx.hiRank.service;

import com.gameFx.hiRank.bean.GameRepository;
import com.gameFx.hiRank.model.Game;
import com.gameFx.hiRank.search.SimilarSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameBrowser implements Discovery {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    SimilarSearch similarSearch;

    @Override
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @Override
    public List<Game> findGameByName(String gameName) {
        return similarSearch.search(gameName);
    }
}
