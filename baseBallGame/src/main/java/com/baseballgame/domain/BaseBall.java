package com.baseballgame.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class BaseBall {
    @Getter
    @Setter
    @NoArgsConstructor
    public static class BaseBallResult extends Game.GameStart {
        private int strike;
        private int ball;
        private int out;
        private boolean correct;
        private int remainingCount;

    }

}
