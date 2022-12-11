package com.baseballgame.GameIdNumber;

import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.baseballgame.api.baseBallApi.gameId;

public class Compare {
    public String howMany(int answer, String resultNum) {
        JsonObject obj = new JsonObject();
        JsonObject data = new JsonObject();


        int strike = 0;
        int ball = 0;
        int out = 0;
        int remainingCount =0;

        String sAnswer = Integer.toString(answer);

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
        obj.addProperty("success", true);

        data.addProperty("correct", true);
        data.addProperty("remainingCount", remainingCount);
        data.addProperty("strike", strike);
        data.addProperty("ball", ball);
        data.addProperty("out", out);

        obj.add("data",data);
        String result ="";
        return obj.toString();

    }
}