package com.example.baseball.controller;

import com.example.baseball.model.GameInfo;
import com.example.baseball.model.GameInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private GameInfoRepository gameInfoRepository;

    @RequestMapping("/")
    public String main(Model model) {
        Date date = new Date();
        gameInfoRepository.save(new GameInfo("1234","jisu", date, 100));

        model.addAttribute("result", gameInfoRepository.getOne(1).getPlayerName());
        return "index";
    }
}