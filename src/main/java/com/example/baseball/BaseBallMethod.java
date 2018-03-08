package com.example.baseball;

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
}
