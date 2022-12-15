package com.baseballgame.application;

import com.baseballgame.domain.BaseBall;
import com.baseballgame.domain.Game;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
@Service

public class GameService {
    private static String gameId;
    private static String gameAnswer;
    public Game.GameStart setGameId(){
        Map<String, Object> gameId = new HashMap<>();
        Game.GameStart gameStart = new Game.GameStart();

        gameStart.setGameId(create());
        gameStart.setSuccess(true);

        gameId.put("success", gameStart.getSuccess());
        gameId.put("gameId", gameStart.getGameId());

        return gameStart;
    }

    public String create(){
        Random random = new Random();
        String ranNum, resultNum = "";
        for (int i = 0; i < 3; i++) {
            ranNum = Integer.toString(random.nextInt(9) +1);
            if (!resultNum.contains(ranNum)) {
                resultNum += ranNum;
            } else {
                i -= 1;
            }
        }
        gameId = "AA" + resultNum;
        gameAnswer = resultNum;
        return resultNum;
    }

    public BaseBall.BaseBallResult answerCompare(int userAnswer){
        System.out.println("userAnswer: " + userAnswer + " gameId: " + gameId + " gameAnswer :" + gameAnswer);
        Map<String, Object> gameAnswerResult = new HashMap<>();
        BaseBall.BaseBallResult bbResult = new BaseBall.BaseBallResult();
        String answer = String.valueOf(userAnswer);

        int strike = 0;
        int ball = 0;
        int out = 0;

        for (int i = 0; i < gameAnswer.length(); i++) {
            if(gameAnswer.charAt(i) == answer.charAt(i)) {
                strike +=1;
            }else{
                if (answer.indexOf(gameAnswer.charAt(i)) != -1) {
                    ball+=1;
                }else{
                    out += 1;
                }
            }
        }


        bbResult.setStrike(strike);
        bbResult.setBall(ball);
        bbResult.setOut(out);
        return bbResult;
    }

}
