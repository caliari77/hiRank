package com.gameFx.hiRank.model;

import javax.persistence.*;

@Entity
public class Rank {

    @Id
    @GeneratedValue
    private String id;
    private Integer rankLevel;

    @OneToOne
    private Game game;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getRankLevel() {
        return rankLevel;
    }

    public void setRankLevel(Integer rankLevel) {
        this.rankLevel = rankLevel;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
