package com.example.baseball.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity @Getter @Setter
public class GameInfo {
    @Id
    @GeneratedValue
    private int idx;

    private String number;
    private String playerName;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private int maxTryNumber;

    private int triedNumber;
    private int point;

    @Builder
    public GameInfo(String number, String playerName, Date date, int maxTryNumber) {
        this.number = number;
        this.playerName = playerName;
        this.date = date;
        this.maxTryNumber = maxTryNumber;
        this.triedNumber = 0;
        this.point = 0;
    }
}
