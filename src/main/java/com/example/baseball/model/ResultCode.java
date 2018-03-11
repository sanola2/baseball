package com.example.baseball.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity @Getter @Setter
public class ResultCode {
    @Id
    private String errorCode;

    @Builder
    public ResultCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
