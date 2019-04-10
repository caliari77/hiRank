package com.gameFx.hiRank.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gameId;
    private String name;
    @OneToOne(cascade=CascadeType.ALL)
    private Rank rank;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "genreId",
            insertable = false,
            updatable = false,
            unique = true)
    private List<Genre> genre;


    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }
}
