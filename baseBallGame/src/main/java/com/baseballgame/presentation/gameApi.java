package com.baseballgame.presentation;

import com.baseballgame.application.GameService;
import com.baseballgame.domain.BaseBall;
import com.baseballgame.domain.Game;
import com.baseballgame.domain.GameResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class gameApi {
    @Autowired
    GameService gameService;


    @PostMapping(value = "/game/start")
    public ResponseEntity<Game.GameStart> gameStart() {
        Game.GameStart gameStart = gameService.setGameId();
        return ResponseEntity.ok(gameStart);
//        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/game/{gameId}/guess")
    public ResponseEntity<BaseBall.BaseBallResult> gameGuess(@RequestParam ("answer") int answer) {
        BaseBall.BaseBallResult baseBallResult = gameService.answerCompare(answer);
        return ResponseEntity.ok(baseBallResult);
//        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/game/{gameId}/history")
    public GameResult<BaseBall.BaseBallResult> gameHistory() {
        return gameService.gameResultList();
    }





}
