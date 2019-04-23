package com.gameFx.hiRank.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "genreId")
    private Long genreId;
    @Column(name = "name", unique = true)
    private String name;

    @JsonBackReference
    @ManyToMany
    @JoinTable(name = "relatedGenres",
            inverseJoinColumns = @JoinColumn(name = "gameId", referencedColumnName = "gameId"),
            joinColumns = @JoinColumn(name = "genreId", referencedColumnName = "genreId")
    )
    private List<Game> gameList;

    @OneToMany(mappedBy = "categoryId")
    private List<Category> categoryList;

    public Genre() {
    }

    public Genre(String name) {
        this.name = name;
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

    public List<Game> getGameList() {
        return gameList;
    }


    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
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

        public Builder withCategoryList(List<Category> categoryList) {
            genre.setCategoryList(categoryList);
            return this;
        }

        public Genre build() {
            return genre;
        }
    }

}
