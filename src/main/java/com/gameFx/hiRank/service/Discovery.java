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
}
