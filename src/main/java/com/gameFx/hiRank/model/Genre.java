package com.gameFx.hiRank.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Genre {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "genreId")
    private Long genreId;
    private String name;

    @ManyToMany
    @JoinColumn(name = "gameId")
    private List<Game> game;

    @OneToMany(mappedBy = "categoryId")
    private List<Category> category;


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

    public List<Game> getGameList() {
        return game;
    }

    public void addGameToList(Game game) {
        this.game.add(game);
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }


}
