package com.gameFx.hiRank.search;

import com.gameFx.hiRank.model.Game;

import java.util.List;

public interface CustomSearch {

    /**
     * Search for game according to search criteria
     * @param criteria search criteria
     * @return List of results
     */
    List<Game> search(String criteria);
}
