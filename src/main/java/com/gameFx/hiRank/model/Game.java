package com.gameFx.hiRank.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "gameId")
    private Long gameId;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    private Rank rank;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "relatedGenres",
            joinColumns = @JoinColumn(name = "gameId", referencedColumnName = "gameId"),
            inverseJoinColumns = @JoinColumn(name = "genreId", referencedColumnName = "genreId")
    )
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

    @Override
    public String toString() {
        return String.format("Game: {0}   rank: {1}", name, rank.getLevel());
    }

    public static class GameBuilder {
        private Game game = new Game();


        public GameBuilder withName(String name) {
            game.setName(name);
            return this;
        }

        public GameBuilder withRank(Rank rank) {
            game.setRank(rank);
            return this;
        }

        public GameBuilder withGenre(List<Genre> genreList) {
            game.setGenreList(genreList);
            return this;
        }

        public Game build() {
            Game completedGame = game;

            return completedGame;
        }

    }


}
