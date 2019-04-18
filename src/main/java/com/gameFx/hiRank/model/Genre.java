package com.gameFx.hiRank.model;

import javax.persistence.*;
import java.util.ArrayList;
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
    private List<Game> gameList;

    @OneToMany(mappedBy = "categoryId")
    private List<Category> categoryList;


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
        return gameList;
    }

    public void addGameToList(Game game) {
        if (gameList == null) {
            gameList = new ArrayList<>();
        }
        gameList.add(game);
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public void addCategoryToList(Category category) {
        if (categoryList == null) {
            categoryList = new ArrayList<>();
        }
        categoryList.add(category);
    }

    public static class Builder {
        private Genre genre;

        public Builder create() {
            genre = new Genre();
            return this;
        }

        public Builder withName(String name) {
            genre.setName(name);
            return this;
        }

        public Builder withGameList(List<Game> gameList) {

            gameList.stream().forEach(game -> {
                genre.addGameToList(game);

            });
            return this;
        }

        public Builder withCategoryList(List<Category> categoryList) {
            categoryList.stream().forEach(genre::addCategoryToList);
            return this;
        }


        public Genre build() {
            return genre;
        }
    }

}
