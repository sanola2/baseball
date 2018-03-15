package com.example.baseball.controller;

import com.example.baseball.BaseBallMethod;
import com.example.baseball.model.GameInfo;
import com.example.baseball.model.GameInfoRepository;
import com.example.baseball.model.ResultCode;
import com.example.baseball.validator.GameInfoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.SortedSet;

@CrossOrigin("*")
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/*")
public class RestController {

    BaseBallMethod baseBallMethod = new BaseBallMethod();

    @Autowired
    private GameInfoRepository gameInfoRepository;

    @RequestMapping("/init")
    public ResponseEntity<?> gameInit(@ModelAttribute("GameInfo") GameInfo gameInfo, BindingResult result) {

        Date date = new Date();

        gameInfo.setNumber(baseBallMethod.genProblemNumber(gameInfoRepository));
        gameInfo.setDate(date);

        GameInfoValidator validator = new GameInfoValidator();
        validator.validate(gameInfo, result);

        if(!result.hasErrors()) {
            gameInfoRepository.save(gameInfo);
            ResultCode resultCode = new ResultCode("200");
            resultCode.setGameInfo(gameInfo);
            return new ResponseEntity<ResultCode>(resultCode, HttpStatus.ACCEPTED);
        }
        ResultCode resultCode = new ResultCode("0");
        return new ResponseEntity<ResultCode>(resultCode, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping("/answer")
    public ResponseEntity<?> getAnswer(@RequestParam String answer, @RequestParam int gameIdx) {
        int[] result;
        result = baseBallMethod.evalAnswer(gameInfoRepository.findNumberByIdx(gameIdx), answer);

        gameInfoRepository.setPointAndTryNum(result[2], gameIdx);

        ResultCode resultCode = new ResultCode("200");
        resultCode.setStrikeCnt(result[0]);
        resultCode.setBallCnt(result[1]);
        return new ResponseEntity<ResultCode>(resultCode, HttpStatus.ACCEPTED);
    }

    @RequestMapping("/history")
    public List<?> getBestHistory() {
        List<GameInfo> result = baseBallMethod.getBestHistory(gameInfoRepository.findAllWinHistory());
        return result;
    }

}
