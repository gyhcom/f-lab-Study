package com.baseballgame.domain;


import lombok.Getter;
import lombok.Setter;

public class BaseBall {
    @Getter
    @Setter
    public static class BaseBallResult{
        private int strike;
        private int ball;
        private int out;
        private boolean correct;
        private int remainingCount;

        @Override
        public String toString() {
            return "BaseBallResult{" +
                    "strike=" + strike +
                    ", ball=" + ball +
                    ", out=" + out +
                    ", correct=" + correct +
                    ", remainingCount=" + remainingCount +
                    '}';
        }
    }

}
