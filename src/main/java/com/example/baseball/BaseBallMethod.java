package com.example.baseball;

import com.example.baseball.model.GameInfo;
import com.example.baseball.model.GameInfoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BaseBallMethod {

    //정답이 될 숫자를 생성하는 메소드 (현재는 3자리숫자로 만듦)
    public String genProblemNumber(GameInfoRepository gameInfoRepository) {
        String result = "";
        Random rand = new Random();

        for (int i = 0; i < 3; i++) {
            int num = rand.nextInt(8);
            result += Integer.toString(num + 1);
        }
        result = checkProblemNumber(gameInfoRepository, result);

        return result;
    }

    //이전 게임에서 사용된 정답과 같은 숫자를 생성하지 않기 위해 체크하는 메소드
    private String checkProblemNumber(GameInfoRepository gameInfoRepository, String problemNumber) {
        List<String> problemNumberFromDb = new ArrayList<>();
        problemNumberFromDb = gameInfoRepository.findAllProblemNumbers();

        if (problemNumberFromDb.contains(problemNumber))
            return genProblemNumber(gameInfoRepository);

        return problemNumber;
    }

    //정답 체크 int 의 index 0 = strike, 1 = ball, 2 = point
    public int[] evalAnswer(int problem, String answer) {
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
        for(int k=0; k< 3; k++)
        result[0] = strike;
        result[1] = ball;

        if(strike == 3)
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
