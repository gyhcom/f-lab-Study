package com.baseballgame.api;

import com.baseballgame.GameIdNumber.Compare;
import com.baseballgame.GameIdNumber.RandomNum;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Slf4j
@RestController
public class baseBallApi {
    public static String gameId;
    public static String gameAnswer;
    public static HashMap<String, Integer> resultMap = new HashMap<>();

    /**
     * gameStart basball 생성(유니크한 3자리)
     */
    @PostMapping(value = "/game/start")
    public String gameId(){
        RandomNum rN = new RandomNum();
        gameAnswer=rN.create();
        gameId="AA"+gameAnswer;

        log.info("BaseBall Game을 시작합니다.");
        log.info("GameId는: "+gameId+" 입니다");

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
        JsonObject obj = new JsonObject();
        Compare cp = new Compare();

    return cp.howMany(answer, gameAnswer);
    }

    @GetMapping(value = "/game/{gameId}")
    @ResponseBody
    public String gemeResult(){
        return "gameResult";
    }

    @GetMapping(value = "/game/{gameId}/history")
    @ResponseBody
    public String gemeHistory(){
        resultMap.put(gameId, Integer.valueOf(gameAnswer));
        String result = "";

        for (String key : resultMap.keySet()) {
            Integer value = resultMap.get(key);
            result += "key : " + key + ",     value : " + value + " \n";
        }
        return result;
    }

}

