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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@org.springframework.stereotype.Controller
public class Controller {
    private final String folderRoot = "/api";
    BaseBallMethod baseBallMethod;

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

        gameInfo.setNumber("111");
        gameInfo.setDate(date);

        GameInfoValidator validator = new GameInfoValidator();
        validator.validate(gameInfo, result);

        if(!result.hasErrors()) {
            gameInfoRepository.save(gameInfo);
            page = "play";
        }
        return page;
    }
}