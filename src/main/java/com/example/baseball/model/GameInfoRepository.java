package com.example.baseball.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameInfoRepository extends JpaRepository<GameInfo, Integer> {
    @Query("select number from GameInfo")
    List<String> findAllProblemNumbers();

}
