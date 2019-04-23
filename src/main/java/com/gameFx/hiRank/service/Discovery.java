package com.gameFx.hiRank.service;

import com.gameFx.hiRank.model.Game;

import java.util.List;

public interface Discovery {

    /**
     * Retrieve all stored Games
     *
     * @return List of games as String
     */
    List<Game> getAllGames();

    /**
     * Find game name by name
     *
     * @param gameName Game name
     * @return a List of similar games
     */
    List<Game> findGameByName(String gameName);
}
