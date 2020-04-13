package com.ay.service;

import com.ay.dto.MoodDTO;
import com.ay.model.Mood;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xiangwehao
 * create 2020/4/7
 */
public interface MoodService {
    List<MoodDTO> findAll();
    Mood findById(String id);
    boolean update(@Param("mood")Mood mood);
    boolean praisedMood(String userId,String moodId);
    boolean praiseMoodForRedis(String userId,String moodId);
    List<MoodDTO> findAllForRedis();
}
