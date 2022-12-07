package com.baseballgame.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class baseBallApi {
    @PostMapping(value = "/game/start")
    public int gameStart(@RequestParam() int gameId){
        System.out.println(gameId);
        return gameId;
    }
}
