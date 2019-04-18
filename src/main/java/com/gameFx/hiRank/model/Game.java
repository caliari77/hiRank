package com.gameFx.hiRank.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gameId;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    private Rank rank;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "genreId",
            insertable = false,
            updatable = false,
            unique = true)
    private List<Genre> genreList;


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

    public List<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }

    public void addGenreToList(Genre genre) {
        if (genreList == null) {
            genreList = new ArrayList();
        }
        genreList.add(genre);
    }

    @Override
    public String toString() {
        return String.format("Game: {0}   rank: {1}", name, rank.getLevel());
    }

    public static class GameBuilder {
        private Game game;

        public GameBuilder create() {
            game = new Game();
            return this;
        }

        public GameBuilder withName(String name) {
            game.setName(name);
            return this;
        }

        public GameBuilder withRank(Rank rank) {
            game.setRank(rank);
            return this;
        }

        public GameBuilder withGenre(List<Genre> genreList) {
            genreList.stream().forEach(genre -> {
                game.addGenreToList(genre);
                genre.addGameToList(game);
            });
            return this;
        }

        public Game build() {
            return game;
        }

    }


}
