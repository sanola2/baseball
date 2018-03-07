package com.example.baseball;

import com.example.baseball.model.GameInfo;
import com.example.baseball.util.BaseBallUtil;
import com.example.baseball.validator.GameInfoValidator;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Assert;

import java.util.Date;

@RunWith(SpringRunner.class)
public class BaseballGameTests {
    GameInfoValidator gameInfoValidator = new GameInfoValidator();
    GameInfo gameInfo;

    @Before
    public void init() {
        Date date = new Date();
        gameInfo = new GameInfo("101", "", date, 0);
    }

    @Test
    public void numValidate() {
        System.out.println("junit Test : " + gameInfo);
        Assert.assertEquals(false, gameInfoValidator.formNumberValidate(gameInfo));
    }

    @Test
    public void stringValidate() {
        System.out.println("junit Test : " + gameInfo);
        Assert.assertEquals(false, gameInfoValidator.formStringValidate(gameInfo));
    }

}
