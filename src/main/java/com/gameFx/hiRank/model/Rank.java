package com.gameFx.hiRank.model;

import javax.persistence.*;

@Entity
public class Rank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer level;

    @Enumerated(EnumType.STRING)
    private RankFormat rankFormat;

    @OneToOne
    private Game game;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
