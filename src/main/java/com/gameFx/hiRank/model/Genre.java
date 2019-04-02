package com.gameFx.hiRank.model;

import javax.persistence.*;
import java.util.List;

public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "genreId")
    private Long genreId;
    private String name;

    //@ManyToMany(mappedBy = "gameId")
    @ManyToMany
    @JoinColumn(name = "gameId")
    private List<Game> game;

    @OneToMany(mappedBy = "categoryId")
    //@OneToMany
    //@JoinColumn(name = "categoryId")
    private Category category;

    public Long getId() {
        return genreId;
    }

    public void setId(Long id) {
        genreId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public List<Game> getGame() {
        return game;
    }

    public void setGame(List<Game> game) {
        this.game = game;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
