package com.baseballgame.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class Game {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class GameStart extends GameResult{
        private String gameId;
    }
}
