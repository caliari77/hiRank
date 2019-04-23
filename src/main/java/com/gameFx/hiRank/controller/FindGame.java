package com.gameFx.hiRank.controller;

import com.gameFx.hiRank.model.Game;
import com.gameFx.hiRank.service.GameBrowser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FindGame {
    @Autowired
    GameBrowser gameBrowser;

    @GetMapping("/findGameByName/{gameName}")
    public List<Game> index(@PathVariable(value="gameName") String gameName){
        return gameBrowser.findGameByName(gameName);
    }
}
