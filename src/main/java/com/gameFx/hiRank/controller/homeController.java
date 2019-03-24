package com.gameFx.hiRank.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class homeController {

    @RequestMapping("/")
    public String index()
    {
        return "Hello world gradle";
    }
}
