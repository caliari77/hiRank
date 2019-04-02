package com.gameFx.hiRank.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gameId;
    private String name;
    @OneToOne
    //@JoinColumn(name = "rankId")
    private Rank rank;

    //@ManyToMany
    //@JoinColumn(name = "genreId")
    @ManyToMany(mappedBy = "genreId")
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

    public Long getId() {
        return gameId;
    }

    public void setId(Long id) {
        gameId = id;
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
