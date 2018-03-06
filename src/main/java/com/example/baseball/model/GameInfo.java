package com.example.baseball.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity @Getter @Setter
public class GameInfo {
    @Id
    @GeneratedValue
    private int idx;

    private String number;
    private String playerName;
    private String date;
    private int maxTryNumber;

    private int triedNumber;
    private int point;

    public GameInfo(String number, String playerName, String date, int maxTryNumber) {
        this.number = number;
        this.playerName = playerName;
        this.date = date;
        this.maxTryNumber = maxTryNumber;
        this.triedNumber = 0;
        this.point = 0;
    }
}
