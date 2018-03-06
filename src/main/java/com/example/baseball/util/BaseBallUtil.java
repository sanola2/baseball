package com.example.baseball.util;

import antlr.StringUtils;
import com.example.baseball.model.GameInfo;

public class BaseBallUtil {
    /*public boolean formValidate(GameInfo data) {

    }*/
    public boolean numberFormValidate(GameInfo data) {
        if(data.getMaxTryNumber() == 0) {
            return false;
        }
        return true;
    }
}
