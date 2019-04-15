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

    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return String.format("Game: {0}   rank: {1}", name, rank.getLevel());
    }

    public static class GameBuilder{
        private Game game;

        public GameBuilder create(){
            game = new Game();
            return this;
        }

        public GameBuilder withName(String name){
            game.setName(name);
            return this;
        }

        public GameBuilder withRank(Rank rank){
            game.setRank(rank);
            return this;
        }

        public GameBuilder withGenre(List<Genre> genre){
            game.setGenre(genre);
            genre.stream().forEach(g -> g.addGameToList(game));
            return this;
        }

        public Game build(){
            return this.game;
        }

    }


}
