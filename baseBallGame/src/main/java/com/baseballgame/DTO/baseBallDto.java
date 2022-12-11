package com.baseballgame.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class baseBallDto {
    private Long strike;
    private Long ball;
    private Long out;
    private boolean correct;
    private int remainingCount;

    @Override
    public String toString() {
        return "baseBallDto{" +
                "strike=" + strike +
                ", ball=" + ball +
                ", out=" + out +
                ", correct=" + correct +
                ", remainingCount=" + remainingCount +
                '}';
    }
}
