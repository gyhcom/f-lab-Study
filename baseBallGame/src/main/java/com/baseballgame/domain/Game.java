package com.baseballgame.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class Game {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class GameStart{
        private Boolean success;
        private String gameId;
        private String gameAnswer;

    }


}
