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
}
