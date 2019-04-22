package com.gameFx.hiRank.controller;

import com.gameFx.hiRank.model.Game;
import com.gameFx.hiRank.service.Discovery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListAllGames {

    @Autowired
    Discovery gameBrowser;

    @GetMapping("/getAllGames")
    public List<Game> index(){
        return gameBrowser.getAllGames();
    }

}
