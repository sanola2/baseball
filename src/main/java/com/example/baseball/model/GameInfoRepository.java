package com.example.baseball.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GameInfoRepository extends JpaRepository<GameInfo, Integer> {
    @Query("select number from GameInfo")
    List<String> findAllProblemNumbers();

    @Query("select number from GameInfo where idx=?1")
    int findNumberByIdx(int idx);

    @Modifying
    @Transactional
    @Query(value = "update game_info set point = point + ?1, tried_number = tried_number + 1 where idx = ?2", nativeQuery = true)
    void setPointAndTryNum(int result, int idx);
}
