package com.example.baseball;

import com.example.baseball.model.GameInfo;
import com.example.baseball.validator.GameInfoValidator;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Assert;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
public class BaseballGameTests {

    @Test
    public void arrayRmTest() {
        String result = "";
        ArrayList<Integer> nums = new ArrayList<>();
        Random rand = new Random();
        for(int i=0; i < 9; i++)
            nums.add(i+1);

        for (int j=0; j < 9; j++) {
            System.out.println(nums.get(j));
        }

        for (int i = 0; i < 9; i++) {
            int ran = rand.nextInt(nums.size());
            int num = nums.get(ran);
            nums.remove(ran);

            result += Integer.toString(num);
        }

        System.out.println(result);
        System.out.println(nums.size());
    }
    @Test
    public void strContainTest() {
        String str = "1234";
        int num = 4;
        boolean result;

        result = str.contains(Integer.toString(num));
        Assert.assertEquals(true, result);
    }

    public String eval() {
        int problem = 135;
        String answer = "133";
        int strike = 0;
        int ball = 0;

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

        return strike + "str" + ball + "ball";
    }

    @Test
    public void evalAnswer() {

        Assert.assertEquals("0str3ball", eval());
    }
//charAt 지ㅈ
    @Test
    public void numValidate() {
        GameInfoValidator gameInfoValidator = new GameInfoValidator();
        GameInfo gameInfo;
        Date date = new Date();
        gameInfo = new GameInfo("101", "", date, 0);
        System.out.println("junit Test : " + gameInfo);
        Assert.assertEquals(false, gameInfoValidator.formNumberValidate(gameInfo));
    }

    //genProblemNumber 테스트하기 위한 메소드
    /*static int i = 0, j = 0 ;
    public String genProblemNumber() {
        String result = "";
        Random rand = new Random();

        for(; i < j+3; i++) {
            int num = i;
            result += Integer.toString(num + 1);
        }
        j += 3;
        System.out.println("젠 프랍 : " + result);
        result = checkProblemNumber(result);

        return result;
    }

    private String checkProblemNumber(String problemNumber) {
        List<String> problemNumberFromDb = new ArrayList<>();
        problemNumberFromDb.add("111");
        problemNumberFromDb.add("222");
        problemNumberFromDb.add("333");
        problemNumberFromDb.add("444");
        problemNumberFromDb.add("123");

        if(problemNumberFromDb.contains(problemNumber))
            return genProblemNumber();
        return problemNumber;
    }
    @Test
    public void genProblemNumber() {
        BaseBallMethod baseBallMethod = new BaseBallMethod();
        Assert.assertEquals("456", baseBallMethod.genProblemNumber());
    }*/

}
