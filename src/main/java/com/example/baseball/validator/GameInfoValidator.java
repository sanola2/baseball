package com.example.baseball.validator;

import com.example.baseball.model.GameInfo;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class GameInfoValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return GameInfo.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        GameInfo gameInfo = (GameInfo) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "playerName", "No Name");
        if(!formNumberValidate(gameInfo)) {
            errors.rejectValue("maxTryNumber", "trouble");
        }
    }

    //입력 받은 숫자 유효성 체크
    public boolean formNumberValidate(GameInfo data) {
        if(data.getMaxTryNumber() == 0)
            return false;
        return true;
    }
}
