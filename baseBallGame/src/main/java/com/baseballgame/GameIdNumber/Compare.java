package com.baseballgame.GameIdNumber;

public class Compare {
    public String howMany(int answer, String resultNum) {
        int strike = 0;
        int ball = 0;
        int out = 0;

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
        return "Strike " + strike + " Ball: " + ball + " Out: " + out;

    }
}
