package com.gameFx.hiRank.dao;

import com.gameFx.hiRank.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface GameRepository extends JpaRepository<Game, Long> {

}
