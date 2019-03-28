package com.gameFx.hiRank.dao;

import com.gameFx.hiRank.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

}
