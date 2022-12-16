package com.baseballgame.presentation;

import com.baseballgame.application.GameService;
import com.baseballgame.domain.BaseBallDto;
import com.baseballgame.domain.GameResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class gameApi {
    @Autowired
    GameService gameService;


    @PostMapping(value = "/game/start")
    public ResponseEntity<GameResultDto> gameStart() {
        GameResultDto gameStart = gameService.setGameId();
        return ResponseEntity.ok(gameStart);
//        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/game/{gameId}/guess")
    public ResponseEntity<BaseBallDto.BaseBallResult> gameGuess(@RequestParam ("answer") int answer) {
        BaseBallDto.BaseBallResult baseBallResult = gameService.answerCompare(answer);
        return ResponseEntity.ok(baseBallResult);
//        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/game/{gameId}/history")
    public GameResultDto<Object> gameHistory() {
        return gameService.gameResultList();
    }





}
