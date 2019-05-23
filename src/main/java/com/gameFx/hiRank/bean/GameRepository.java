package com.gameFx.hiRank.bean;

import com.gameFx.hiRank.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface GameRepository extends JpaRepository<Game, Long> {

    /**
     * Find Game by its name.
     *
     * @param gameName Game name
     * @return Game
     */
    Optional<Game> findAllByName(String gameName);


}
