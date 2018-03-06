package com.example.baseball.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/*")
public class RestController {
    @RequestMapping("/a")
    public String a() {
        return "aaaaaaa";
    }

  /*  @RequestMapping("/click")
    public int click() {
        int a, b;
        a = 3;
        b = 5;
        return a+b;
    }*/

}
