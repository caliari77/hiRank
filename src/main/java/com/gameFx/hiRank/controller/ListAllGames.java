package com.gameFx.hiRank.controller;

import com.gameFx.hiRank.model.Game;
import com.gameFx.hiRank.service.Discovery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListAllGames {

    private final Discovery gameBrowser;

    public ListAllGames(Discovery gameBrowser) {
        this.gameBrowser = gameBrowser;
    }


    @GetMapping("/getAllGames")
    public List<Game> index() {
        return gameBrowser.getAllGames();
    }

}
