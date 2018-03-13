package com.example.baseball.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity @Getter @Setter @NoArgsConstructor
public class ResultCode {
    @Id
    private String errorCode;

    @OneToOne
    private GameInfo gameInfo;

    private int strikeCnt;
    private int ballCnt;


    @Builder
    public ResultCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
