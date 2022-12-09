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
     * gameStart basball 답변 생성(유니크한 3자리)
     */
    @PostMapping(value = "/game/start")
    public void gameStart(){
        String gameId = "sss";

    }

    /**
     * @param answer
     */
    @PostMapping(value = "/game/{gameId}/guess")
    public void gameGuess(@RequestParam int answer){
        System.out.println("사용자 답변 " + answer);
        Random random = new Random();

        int strike = 0;
        int ball = 0;
        int out = 0;
        String ranNum,resultNum ="";
        String sAnswer = Integer.toString(answer);


        for(int i = 0; i < 3; i++){
            ranNum = Integer.toString(random.nextInt(9));
            if(!resultNum.contains(ranNum)){
                resultNum += ranNum;
            }else {
                i -= 1;
            }
        }

        for(int i = 0; i < resultNum.length(); i++) {
            if(resultNum.charAt(i) == sAnswer.charAt(i)){
                strike +=1;
            }else{

                }
            }
        }



        log.info("베이스볼 게임 답변 " + resultNum +" 입니다.");
}
