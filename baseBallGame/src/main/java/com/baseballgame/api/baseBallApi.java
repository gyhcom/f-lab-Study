package com.baseballgame.api;

import com.baseballgame.GameIdNumber.Compare;
import com.baseballgame.GameIdNumber.RandomNum;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class baseBallApi {
    public static String gameId;
    public static String gameAnswer;
    /**
     * gameStart basball 생성(유니크한 3자리)
     */
    @PostMapping(value = "/game/start")
    public String gameId(){
        log.info("BaseBall Game을 시작합니다.");
        RandomNum rN = new RandomNum();
        gameId="AA"+rN.create();
        gameAnswer=rN.create();

        JsonObject obj = new JsonObject();
        JsonObject data = new JsonObject();

        obj.addProperty("success", true);
        data.addProperty("gameId",gameId);

        obj.add("data", data);

    return obj.toString();
    }

    /**
     * @param answer
     */
    @PostMapping(value = "/game/{gameId}/guess")
    @ResponseBody
    public String gameGuess(@RequestParam int answer) {
        Compare cp = new Compare();
        gameAnswer =cp.howMany(answer, gameAnswer);
    return gameAnswer;
    }
}

