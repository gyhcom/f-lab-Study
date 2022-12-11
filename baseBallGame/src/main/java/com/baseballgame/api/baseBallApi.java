package com.baseballgame.api;

import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@RestController
public class baseBallApi {
    public static String gameId;
    /**
     * gameStart basball 생성(유니크한 3자리)
     */
    @PostMapping(value = "/game/start")
    public String gameId(){
        Random random = new Random();
        String ranNum, resultNum = "";

        for (int i = 0; i < 2; i++) {
            ranNum = Integer.toString(random.nextInt(9));
            if (!resultNum.contains(ranNum)) {
                resultNum += ranNum;
            } else {
                i -= 1;
            }
        }
        gameId = "AA" + resultNum;

        JsonObject obj = new JsonObject();
        obj.addProperty("success", true);

        JsonObject data = new JsonObject();
        data.addProperty("gameId",gameId);

        obj.add("data", data);

    return obj.toString();
    }

    /**
     * @param answer
     */
    @PostMapping(value = "/game/{gameId}/guess")
    @ResponseBody
    public void gameGuess(@RequestParam int answer) {

        Random random = new Random();

        int strike = 0;
        int ball = 0;
        int out = 0;
        String ranNum, resultNum = "";
        String sAnswer = Integer.toString(answer);


        for (int i = 0; i < 3; i++) {
            ranNum = Integer.toString(random.nextInt(9));
            if (!resultNum.contains(ranNum)) {
                resultNum += ranNum;
            } else {
                i -= 1;
            }
        }

        for (int i = 0; i < resultNum.length(); i++) {
            if (resultNum.charAt(i) == sAnswer.charAt(i)) {
                strike += 1;
            } else {
                if(sAnswer.indexOf(resultNum.charAt(i))!=-1){
                    ball+=1;
                }else{
                    out+=1;
                }
            }
        }

        log.info("베이스볼 게임 답변 " + resultNum + " 입니다.");
        log.info("사용자 답변 " + answer);
        log.info("strike " + strike +" ball " + ball + " out " +out);
    }
}

