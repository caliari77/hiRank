package com.gameFx.hiRank.model;

import javax.persistence.*;

@Entity
public class Category {

    @Id
    @GeneratedValue
    private String id;
    private String name;

    @ManyToOne
    private Genre genre;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
