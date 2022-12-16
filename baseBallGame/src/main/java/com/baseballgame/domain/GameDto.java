package com.baseballgame.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class GameDto {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class GameStart extends GameResultDto {
        private String gameId;
    }
}
