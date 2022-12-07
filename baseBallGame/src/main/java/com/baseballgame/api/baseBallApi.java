package com.baseballgame.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@Slf4j
@RestController
public class baseBallApi {

    /**
     * gameStart gameId 생성(유니크한 3자리)
     */
    @PostMapping(value = "/game/start")
    public void gameStart(){
        Random random = new Random();

        int gameId;
        String ranNum="";
        String resultNum="";

        for(int i = 0; i < 3; i++){

            ranNum = Integer.toString(random.nextInt(9));
            if(!resultNum.contains(ranNum)){
                resultNum += ranNum;
            }else {
                i -= 1;
            }

        }
        log.info("게임 아이디는 " + resultNum +" 입니다.");
    }

    /**
     * @param gameId
     * gameGuess 게임 진행
     */
    @PostMapping(value = "/game/{gameId}/guess")
    public void gameGuess(@PathVariable String gameId){
        log.info(gameId);
    }
}
