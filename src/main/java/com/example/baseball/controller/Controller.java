package com.example.baseball.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping("/")
    public String main(Model model) {
       // model.addAttribute("result", "maiasdasdn"); 포스트 인자 넘기는것
        return "index";
    }
}
