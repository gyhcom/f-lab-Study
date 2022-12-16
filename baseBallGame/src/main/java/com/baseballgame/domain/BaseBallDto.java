package com.baseballgame.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class BaseBallDto {
    @Getter
    @Setter
    @NoArgsConstructor
    public static class BaseBallResult extends GameDto.GameStart {
        private int strike;
        private int ball;
        private int out;
        private boolean correct;
        private int remainingCount;

    }

}
