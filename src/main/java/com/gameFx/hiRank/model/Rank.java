package com.gameFx.hiRank.model;

import javax.persistence.*;

@Entity
public class Rank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer level;

    @Enumerated(EnumType.STRING)
    private RankFormat rankFormat;

    public Rank(Integer level, RankFormat rankFormat) {
        this.level = level;
        rankFormat = rankFormat;
    }

    public RankFormat getRankFormat() {
        return rankFormat;
    }

    public void setRankFormat(RankFormat rankFormat) {
        this.rankFormat = rankFormat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

}
