package com.baseballgame.application;

import com.baseballgame.domain.BaseBallDto;
import com.baseballgame.domain.GameDto;
import org.springframework.stereotype.Service;
import com.baseballgame.domain.GameResultDto;

import java.util.*;

@Service

public class GameService {
    private static String gameId;
    private static String gameAnswer;
    private List resultList= new ArrayList<>();
    public GameResultDto setGameId(){
        Map<String, Object> gameId = new HashMap<>();
        GameDto.GameStart gameStart = new GameDto.GameStart();

        gameStart.setGameId(create());
        gameStart.setSuccess(true);

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

    public BaseBallDto.BaseBallResult answerCompare(int userAnswer){
        Map<String, Object> gameAnswerResult = new HashMap<>();
        BaseBallDto.BaseBallResult bbResult = new BaseBallDto.BaseBallResult();
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
        bbResult.setSuccess(true);

        gameAnswerResult.put("strike", strike);
        gameAnswerResult.put("ball", ball);
        gameAnswerResult.put("out", out);

        resultList.add(gameAnswerResult);

        return bbResult;
    }

    public <T> GameResultDto<T> gameResultList(){
        GameResultDto<T> result = new GameResultDto<>();
        result.setData(resultList);
        return result;
    }

}
