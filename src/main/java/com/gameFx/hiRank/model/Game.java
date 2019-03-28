package com.gameFx.hiRank.model;


import javax.persistence.*;

@Entity
public class Game {

    @Id
    @GeneratedValue
    private String id;
    private String name;

    @ManyToMany
    private Genre genre;

    @OneToOne
    private Rank rank;

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



    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }
}
