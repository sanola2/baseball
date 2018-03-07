package com.example.baseball.validator;

import com.example.baseball.model.GameInfo;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class GameInfoValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return GameInfo.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        GameInfo gameInfo = (GameInfo) target;

    }


    //입력받은 사용자 이름 널 체크
    public boolean formStringValidate(GameInfo data) {
        if(data.getPlayerName() == null || data.getPlayerName().trim().isEmpty())
            return false;
        return true;
    }

    //입력 받은 숫자 유효성 체크
    public boolean formNumberValidate(GameInfo data) {
        if(data.getMaxTryNumber() == 0)
            return false;
        return true;
    }
}
