package com.example.baseball;

import com.example.baseball.model.GameInfo;
import com.example.baseball.model.GameInfoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BaseBallMethod {

    //정답이 될 숫자를 생성하는 메소드
    public String genProblemNumber(GameInfoRepository gameInfoRepository, int probNum) {
        String result = "";
        int numCnt;
        ArrayList<Integer> numTemp = new ArrayList<>();
        Random rand = new Random();

        for(int i = 0; i < 9; i++)
            numTemp.add(i+1);

        if(probNum > 9)
            numCnt = 9;
        else
            numCnt = probNum;

        for (int i = 0; i < numCnt; i++) {
            int ranNum = rand.nextInt(numTemp.size());
            int num = numTemp.get(ranNum);
            numTemp.remove(ranNum);

            result += Integer.toString(num);
        }
        result = checkProblemNumber(gameInfoRepository, result, probNum);

        return result;
    }

    //이전 게임에서 사용된 정답과 같은 숫자를 생성하지 않기 위해 체크하는 메소드
    private String checkProblemNumber(GameInfoRepository gameInfoRepository, String problemNumber, int probNum) {
        List<String> problemNumberFromDb = new ArrayList<>();
        problemNumberFromDb = gameInfoRepository.findAllProblemNumbers();

        if (problemNumberFromDb.contains(problemNumber))
            return genProblemNumber(gameInfoRepository, probNum);

        return problemNumber;
    }

    //정답 체크 int 의 index 0 = strike, 1 = ball, 2 = point
    public int[] evalAnswer(int problem, String answer, int probNum) {
        int strike = 0;
        int ball = 0;
        int[] result = new int[3];

        String strProblem = String.valueOf(problem);

        for(int i = 0; i< answer.length(); i++) {
            for(int j = 0; j< strProblem.length(); j++) {
                if(answer.charAt(i) == strProblem.charAt(j)) {
                    if(answer.charAt(i) == strProblem.charAt(i)) {
                        strike++;
                    } else
                        ball++;
                    break;
                }
            }
        }
        result[0] = strike;
        result[1] = ball;

        if(strike == probNum)
            result[2] = 10000;
        else
            result[2] = strike*3 + ball*1;

        return result;
    }

    //db에서 승리한 데이터를 가져와서 어떠게 가장 적은 시도인지 판별
    public List<GameInfo> getBestHistory(List<GameInfo> winDatas) {
        List<GameInfo> result = new ArrayList<GameInfo>();
        result.add(winDatas.get(0));

        for(int i = 1; i < winDatas.size(); i++) {
            int winDatasTriedNumber = winDatas.get(i).getTriedNumber();
            if(result.get(0).getTriedNumber() > winDatasTriedNumber) {
                result.clear();
                result.add(winDatas.get(i));
            } else if (result.get(0).getTriedNumber() == winDatasTriedNumber) {
                boolean flag = true;

                for(int j = 0; j < result.size(); j++) {
                    if(result.get(j).getIdx() == winDatas.get(i).getIdx())
                        flag = false;
                }

                if(flag)
                    result.add(winDatas.get(i));
            }
        }

        return result;
    }


}
