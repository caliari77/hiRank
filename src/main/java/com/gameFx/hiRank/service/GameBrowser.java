package com.gameFx.hiRank.service;

import com.gameFx.hiRank.bean.GameRepository;
import com.gameFx.hiRank.model.Game;
import com.gameFx.hiRank.search.SimilarSearch;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameBrowser implements Discovery {

    private final GameRepository gameRepository;
    private final SimilarSearch similarSearch;

    public GameBrowser(GameRepository gameRepository, SimilarSearch similarSearch) {
        this.gameRepository = gameRepository;
        this.similarSearch = similarSearch;
    }

    @Override
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @Override
    public List<Game> findGameByName(String gameName) {
        return similarSearch.search(gameName);
    }
}
