package com.example.baseball.controller;

import com.example.baseball.BaseBallMethod;
import com.example.baseball.model.GameInfo;
import com.example.baseball.model.GameInfoRepository;
import com.example.baseball.validator.GameInfoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Date;

@org.springframework.stereotype.Controller
public class Controller {
    private final String folderRoot = "/api";
    BaseBallMethod baseBallMethod = new BaseBallMethod();

    @Autowired
    private GameInfoRepository gameInfoRepository;

    @RequestMapping("/")
    public String main(Model model) {

     //  model.addAttribute("result", gameInfoRepository.getOne(1).getPlayerName());
        return "index";
    }

    @RequestMapping(folderRoot + "/init")
    public String gameInit(@ModelAttribute("GameInfo") GameInfo gameInfo, BindingResult result) {

        String page = "redirect:/";
        Date date = new Date();

        gameInfo.setNumber(baseBallMethod.genProblemNumber(gameInfoRepository));
        gameInfo.setDate(date);

        GameInfoValidator validator = new GameInfoValidator();
        validator.validate(gameInfo, result);

        if(!result.hasErrors()) {
            gameInfoRepository.save(gameInfo);
            page = "play";
        }
        return page;
    }

    @RequestMapping(folderRoot + "/test")
    public String test(Model model) {
        System.out.println("버튼 동작");
        return "play";
    }
}