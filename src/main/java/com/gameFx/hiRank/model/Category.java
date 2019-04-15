package com.gameFx.hiRank.model;

import javax.persistence.*;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryId;
    private String name;

    @ManyToOne
    @JoinColumn(name = "genreId")
    private Genre genre;

    public Long getId() {
        return categoryId;
    }

    public void setId(Long id) {
        categoryId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public class Builder{
        private Category category;

        public Builder create(){
            category = new Category();
            return this;
        }

        public Builder withName(String name){
            category.setName(name);
            return this;
        }

        public Builder withGenre(Genre genre){
            category.setGenre(genre);

            return this;
        }


    }

}
