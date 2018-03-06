package com.example.baseball;

import com.example.baseball.model.GameInfo;
import com.example.baseball.model.GameInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;


@SpringBootApplication
public class BaseballGame {
	Date date = new Date();

	@Autowired
	private GameInfoRepository gameInfoRepository;


	public static void main(String[] args) {
		SpringApplication.run(BaseballGame.class, args);
	}
}
