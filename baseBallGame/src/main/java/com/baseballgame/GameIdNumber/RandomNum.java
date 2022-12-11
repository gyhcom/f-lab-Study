package com.baseballgame.GameIdNumber;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
@Slf4j
public class RandomNum {
    public int randomMake(){
        Random random = new Random();
        return random.nextInt(9) +1;
    }

    public String create(){
        String ranNum, resultNum = "";
        for (int i = 0; i < 3; i++) {
            ranNum = Integer.toString(randomMake());
            if (!resultNum.contains(ranNum)) {
                resultNum += ranNum;
            } else {
                i -= 1;
            }
        }
        return resultNum;
    }

}
